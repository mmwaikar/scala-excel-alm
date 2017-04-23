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
    println(s"Current dir: $currentDir")

    val excelData = readExcel("docs/DOC-HTMR-9PPGPZ-5.5.csv")
    val interimData = excelData.map(ed => InterimData(ed.risk, InterimData.clean(Parser.parseAll(ed.rcm))))
    logger.debug(s"interim data: ${interimData}")

    val finalData = ListBuffer[ExcelData]()
    interimData.map(id => {
      val riskId = id.risk
      id.rcms.map(rcm => finalData += ExcelData(riskId, rcm))
    })
    logger.debug(s"final data: ${finalData}")

    createCsvFile("docs/output.csv", finalData)
  }

  def readExcel(filename: String): List[ExcelData] = {
    val reader = CSVReader.open(new File(filename))
    val rows = reader.allWithHeaders()
    val data = rows.map(r => ExcelData(r(Constants.riskColumn), r(Constants.rcmColumn)))
    data
  }

  def createCsvFile(path: String, data: Seq[ExcelData]) = {
    val header = List("Output")
    val outputData = data.map(d => Seq(s"${d.risk} trace to ${d.rcm}"))
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
