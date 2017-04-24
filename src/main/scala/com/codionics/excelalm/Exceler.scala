package com.codionics.excelalm

import java.io.File

import com.github.tototoshi.csv.{CSVReader, CSVWriter}
import com.typesafe.scalalogging.Logger

import scala.collection.mutable.ListBuffer

/**
  * Created by mmwaikar on 23-04-17.
  */
object Exceler {
  val logger = Logger(Exceler.getClass)

  def main(args: Array[String]): Unit = {
    val currentDir = System.getProperty("user.dir")
//    println(s"Current dir: $currentDir")

    val cmdLineParser = CmdLineParser.getParser()
    val optConfig = CmdLineParser.parseCmdLineArgs(cmdLineParser, args)

    optConfig match {
      case Some(config) => readAndWrite(config)
      case None =>
    }
  }

  def readAndWrite(config: Config) = {
    val inputCsvPath = s"${config.dirName}/${config.inputFileName}"
    val outputCsvPath = s"${config.dirName}/${config.outputFileName}"

    val excelData = readExcel(inputCsvPath)
    val interimData = excelData.map(ed => InterimData(ed.risk, InterimData.clean(Parser.parseAll(ed.rcm))))
//    logger.debug(s"interim data: ${interimData}")

    val finalData = ListBuffer[ExcelData]()
    interimData.map(id => {
      val riskId = id.risk
      id.rcms.map(rcm => finalData += ExcelData(riskId, rcm))
    })
//    logger.debug(s"final data: ${finalData}")

    createCsvFile(outputCsvPath, finalData)
  }

  def readExcel(filename: String): List[ExcelData] = {
    val reader = CSVReader.open(new File(filename))
    val rows = reader.allWithHeaders()
    val data = rows.map(r => ExcelData(r(Constants.riskColumn), r(Constants.rcmColumn)))
    data
  }

  def createCsvFile(path: String, data: Seq[ExcelData]) = {
    val header = List(Constants.outputCol)
    val outputData = data.map(d => Seq(s"${d.risk} Traced To ${d.rcm}"))
    writeToCsvFile(path, header, outputData)
  }

  def writeToCsvFile(path: String, header: Seq[Any], ts: Seq[Seq[Any]]) = {
    val f = new File(path)
    if (f.createNewFile()) println("File is created!") else println ("Overwrite already existing file!")

    val writer = CSVWriter.open(f)
    writer.writeRow(header)
    writer.writeAll(ts)
    writer.close()
  }
}
