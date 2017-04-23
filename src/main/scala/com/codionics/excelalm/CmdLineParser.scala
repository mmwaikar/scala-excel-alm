package com.codionics.excelalm

import scopt.OptionParser

/**
  * Created by mmwaikar on 23-04-17.
  */
object CmdLineParser {
  def getParser(): OptionParser[Config] = {
    val parser = new OptionParser[Config]("scopt") {
      head("scopt", "3.5.0")

      opt[String]('d', "dirName").required().valueName("<dirName>")
        .action( (x, c) => c.copy(dirName = x) )
        .text("dirName is the name of the directory that contains input files (default - docs)")

      opt[String]('i', "inputFileName").required().valueName("<inputFileName>")
        .action( (x, c) => c.copy(inputFileName = x) )
        .text("inputFileName is the name of the input CSV file (default - input.csv)")

      opt[String]('o', "outputFileName").required().valueName("<outputFileName>")
        .action( (x, c) => c.copy(outputFileName = x) )
        .text("outputFileName is the name of the output CSV file (default - output.csv)")

      help("help").text("prints this usage text")
    }

    parser
  }

  def parseCmdLineArgs(parser: OptionParser[Config], args: Array[String]): Option[Config] = {
    parser.parse(args, Config())
  }
}
