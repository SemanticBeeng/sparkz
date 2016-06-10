organization := "com.github.gm-spacagna"

name := "sparkz"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
<<<<<<< HEAD
  "joda-time" % "joda-time" % "2.6",
  "org.joda" % "joda-convert" % "1.2",
  "org.apache.spark" % "spark-core_2.11" % "1.6.1",
  "org.apache.spark" % "spark-mllib_2.11" % "1.6.1",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1",
  "org.scalaz" %% "scalaz-core" % "7.2.3",
  "org.rogach" %% "scallop" % "1.0.1",
  "org.scala-lang" % "scalap" % "2.10.4",
  "org.scala-lang" % "scala-compiler" % "2.11.8",
  "org.typelevel" %% "scalaz-specs2" % "0.3.0" % "test"
=======
  "joda-time" % "joda-time" % "2.9.3",
  "org.joda" % "joda-convert" % "1.8.1",
  "org.apache.spark" %% "spark-core" % "1.6.1" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-mllib" % "1.6.1" withSources() withJavadoc(),
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3",
  "org.scalaz" %% "scalaz-core" % "7.1.7" withSources() withJavadoc(),
  "org.rogach" %% "scallop" % "1.0.0",
  "org.specs2" %% "specs2-core" % "3.7.2-scalaz-7.1.7" % "test",
  "org.specs2" %% "specs2-scalacheck" % "3.7.2-scalaz-7.1.7" % "test"
>>>>>>> 7d15bb2afa1fe00bae6ed947cebe28cfc6a7ae6a
)

resolvers ++= Seq(
  "Maven Central" at "https://repo1.maven.org/maven2/"
)
