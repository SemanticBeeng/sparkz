package sparkz.evaluation

import org.apache.spark.rdd.RDD
import sparkz.classifiers.{BinaryClassifierTrainer, FeaturesWithBooleanLabel, MetaData}
import sparkz.utils.AppLogger

import scala.reflect.ClassTag
import scalaz.Scalaz._

object BinaryClassifierEvaluation {
  def crossValidation[Features, Meta, Order: Ordering : ClassTag, UniqueKey: ClassTag](data: RDD[FeaturesWithBooleanLabel[Features] with MetaData[Meta]],
                                                                                       k: Int,
                                                                                       classifier: BinaryClassifierTrainer[Features],
                                                                                       uniqueId: Meta => UniqueKey,
                                                                                       orderingField: Meta => Order,
                                                                                       singleInference: Boolean = true,
                                                                                       seed: Long = 12345L)
                                                                                      (implicit logger: AppLogger = AppLogger.infoLevel()): RDD[(FeaturesWithBooleanLabel[Features] with MetaData[Meta], Double)] =
    (for {
      i <- 0 until k
      otherFolds = data.filter(_.metaData |> uniqueId |> (_.hashCode() % k == i))
      holdoutFold = data.filter(_.metaData |> uniqueId |> (_.hashCode() % k != i))

      splitMax = holdoutFold
                 .keyBy(_.metaData |> uniqueId)
                 .mapValues(_.metaData |> orderingField)
                 .reduceByKey((record1, record2) => Array(record1, record2).max)
                 .values.min

      Array(splitPoint) = holdoutFold.map(_.metaData |> orderingField).filter(_ < splitMax)
                          .takeSample(withReplacement = false, num = 1, seed = seed)

      trainingData = otherFolds.filter(_.metaData |> orderingField |> (_ <= splitPoint))
      holdoutFoldAfterSplit = holdoutFold.filter(_.metaData |> orderingField |> (_ > splitPoint))

      testData = if (singleInference)
        holdoutFoldAfterSplit.keyBy(_.metaData |> uniqueId)
        .reduceByKey((record1, record2) => Array(record1, record2).minBy(_.metaData |> orderingField))
        .values
      else holdoutFoldAfterSplit

      model = classifier.train(trainingData)
    } yield testData -> model).map {
      case (testData, model) => testData.map(testRecord => testRecord -> model.score(testRecord.features))
    }
    .reduce(_ ++ _)
}
