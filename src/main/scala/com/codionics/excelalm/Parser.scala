package com.codionics.excelalm

import com.typesafe.scalalogging.Logger

/**
  * Created by mmwaikar on 22-04-17.
  */
object Parser {
  val logger = Logger(Parser.getClass)

  def parse(cellText: String): Seq[String] = {
//    val srsPattern = "SRS: (\\d)*(.*?)SRS:(\\d)*"
//    val ssrsLabellingPattern = "SSRS_Labeling: (\\d)*(.*?)SSRS_Labeling:(\\d)*"

    val srsPattern = "SRS: (\\d)*|SRS:(\\d)*"
    val ssrsLabellingPattern = "SSRS_Labeling: (\\d)*|SSRS_Labeling:(\\d)*"

    val pattern = s"$srsPattern(.*?)$ssrsLabellingPattern".r
    logger.debug(s"pattern: $pattern")
    pattern findAllIn cellText toSeq
  }
}
