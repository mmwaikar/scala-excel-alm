import sbt._

object Dependencies {
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.1.7"
  lazy val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
  lazy val poi = "org.apache.poi" % "poi" % "3.16"
  lazy val poiOoXml = "org.apache.poi" % "poi-ooxml" % "3.16"
  lazy val stax = "stax" % "stax-api" % "1.0.1"
  lazy val scalaCsv = "com.github.tototoshi" %% "scala-csv" % "1.3.4"
  lazy val scopt = "com.github.scopt" %% "scopt" % "3.5.0"
//  lazy val spark = "org.apache.spark" %% "spark-core_2.11" % "2.1.0"
//  lazy val sparkExcel = "com.crealytics" %% "spark-excel_2.11" % "0.8.2"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
}
