import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.codionics",
      scalaVersion := "2.12.1",
      version      := "0.0.2"
    )),
    name := "scala-excel-alm",

    libraryDependencies ++= Seq(
      logback,
      scalaLogging,
      scalaCsv,
      scopt,
//      poi,
//      stax,
//      poiOoXml,
//      spark,
//      sparkExcel,

      scalaTest % Test
    ),

    mainClass in (Compile, run) := Some("com.codionics.excelalm.Exceler"),

    mainClass in (Compile, packageBin) := Some("com.codionics.excelalm.Exceler")
  )
