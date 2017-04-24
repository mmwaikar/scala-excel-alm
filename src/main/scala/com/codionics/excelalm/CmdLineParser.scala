package com.codionics.excelalm

import scopt.OptionParser

/**
  * Created by mmwaikar on 23-04-17.
  */
object CmdLineParser {
  def getParser(): OptionParser[Config] = {
    val helpMsg =
      """This utility works with CSV files, so please convert your *.xlsx files to *.csv files.
        |Please create a docs (or any other name you want) directory to keep your input / output csv files.
      """.stripMargin

    val p = getClass.getPackage
    val name = p.getImplementationTitle
    val ver = p.getImplementationVersion
    val usage = s"java -jar $name-assembly-$ver.jar"

    val parser = new OptionParser[Config](usage) {
      head(name, ver)

      opt[String]('d', "dirName").valueName("<dirName>")
        .action( (x, c) => c.copy(dirName = x) )
        .text("dirName is the name of the directory that contains input files (default - docs)")

      opt[String]('i', "inputFileName").required().valueName("<inputFileName>")
        .action( (x, c) => c.copy(inputFileName = x) )
        .text("inputFileName is the name of the input CSV file (default - input.csv)")

      opt[String]('o', "outputFileName").valueName("<outputFileName>")
        .action( (x, c) => c.copy(outputFileName = x) )
        .text("outputFileName is the name of the output CSV file (default - output.csv)")

      help("help").text(helpMsg)
    }

    parser
  }

  def parseCmdLineArgs(parser: OptionParser[Config], args: Array[String]): Option[Config] = {
    parser.parse(args, Config())
  }
}
