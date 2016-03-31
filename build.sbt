organization := "com.github.gm-spacagna"

name := "sparkz"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.6",
  "org.joda" % "joda-convert" % "1.2",
  "org.apache.spark" %% "spark-core" % "1.6.1" withSources() withJavadoc(),
  "org.apache.spark" %% "spark-mllib" % "1.6.1" withSources() withJavadoc(),
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3",
  "org.scalaz" %% "scalaz-core" % "7.2.1" withSources() withJavadoc(),
  "org.rogach" %% "scallop" % "0.9.5",
//  "org.scala-lang" % "scalap" % "2.10.4" withSources() withJavadoc(),
//  "org.scala-lang" % "scala-compiler" % "2.10.4" withSources() withJavadoc(),
  "org.specs2" %% "specs2-core" % "2.4.9-scalaz-7.0.6" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-scalacheck" % "2.4.9-scalaz-7.0.6" % "test" 
)

resolvers ++= Seq(
  "mvnrepository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Maven Central" at "https://repo1.maven.org/maven2/"
)
