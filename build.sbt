organization := "com.github.gm-spacagna"

name := "sparkz"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.6" withSources() withJavadoc(),
  "org.joda" % "joda-convert" % "1.2" withSources() withJavadoc(),
  "org.apache.spark" % "spark-core_2.10" % "1.3.0-cdh5.4.4" withSources() withJavadoc(),
  "org.apache.spark" % "spark-mllib_2.10" % "1.3.0-cdh5.4.4" withSources() withJavadoc(),
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2" withSources() withJavadoc(),
  "org.scalaz" %% "scalaz-core" % "7.0.6" withSources() withJavadoc(),
  "org.rogach" %% "scallop" % "0.9.5" withSources() withJavadoc(),
  "org.scala-lang" % "scalap" % "2.10.4" withSources() withJavadoc(),
  "org.scala-lang" % "scala-compiler" % "2.10.4" withSources() withJavadoc(),
  "org.specs2" %% "specs2-core" % "2.4.9-scalaz-7.0.6" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-scalacheck" % "2.4.9-scalaz-7.0.6" % "test" withSources() withJavadoc()
)

resolvers ++= Seq(
  "mvnrepository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Maven Central" at "https://repo1.maven.org/maven2/"
)
