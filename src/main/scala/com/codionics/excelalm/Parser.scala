package com.codionics.excelalm

import com.typesafe.scalalogging.Logger

/**
  * Created by mmwaikar on 22-04-17.
  */
object Parser {
  val logger = Logger(Parser.getClass)

  def parseFirst(cellText: String): Seq[String] = {
//    val srsPattern = "SRS: (\\d)*(.*?)SRS:(\\d)*"
//    val ssrsLabellingPattern = "SSRS_Labeling: (\\d)*(.*?)SSRS_Labeling:(\\d)*"

    val srsPattern = "SRS: (\\d)*|SRS:(\\d)*"
    val ssrsLabellingPattern = "SSRS_Labeling: (\\d)*|SSRS_Labeling:(\\d)*"

    val pattern = s"$srsPattern(.*?)$ssrsLabellingPattern".r
    logger.debug(s"pattern: $pattern")
    pattern findAllIn cellText toSeq
  }

  def parse(cellText: String): Seq[String] = {
    val patternWithoutSpace = "SRS:(\\d)*(.*?)SSRS_Labeling:(\\d)*"
    val patternWithSpace = "SRS: (\\d)*(.*?)SSRS_Labeling: (\\d)*"

    val pattern = s"$patternWithoutSpace|$patternWithSpace".r
    logger.debug(s"pattern: $pattern")
    pattern findAllIn cellText toSeq
  }

  def parseSrs(cellText: String): Seq[String] = {
    getParseFn(Constants.srsWithSpace, Constants.srsWithoutSpace)(cellText)
  }

  private def getParseFn(withSpace: String, withoutSpace: String) = (cellText: String) => {
    val patternWithoutSpace = withoutSpace.r
    val withoutSpaces = (patternWithoutSpace findAllIn cellText).toSeq
    logger.debug(s"withoutSpaces: ${withoutSpaces.mkString(", ")}")

    val patternWithSpace = withSpace.r
    val withSpaces = (patternWithSpace findAllIn cellText).toSeq
    logger.debug(s"withSpaces: ${withSpaces.mkString(", ")}")

    val all = withSpaces ++ withoutSpaces
    logger.debug(s"all: ${all.mkString(", ")}")
    all
  }
}
