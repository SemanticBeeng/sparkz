organization := "com.github.gm-spacagna"

name := "sparkz"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.3",
  "org.joda" % "joda-convert" % "1.8.1",
  "org.apache.spark" % "spark-core_2.11" % "1.6.1",
  "org.apache.spark" % "spark-mllib_2.11" % "1.6.1",
  "com.github.scala-incubator.io" % "scala-io-file_2.11" % "0.4.3",
  "org.scalaz" %% "scalaz-core" % "7.1.7",
  "org.rogach" %% "scallop" % "1.0.0",
  "org.scala-lang" % "scalap" % "2.11.7",
  "org.scala-lang" % "scala-compiler" % "2.11.7",
  "org.specs2" %% "specs2-core" % "3.7.2-scalaz-7.1.7" % "test",
  "org.specs2" %% "specs2-scalacheck" % "3.7.2-scalaz-7.1.7" % "test"
)

resolvers ++= Seq(
  "mvnrepository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Maven Central" at "https://repo1.maven.org/maven2/"
)
