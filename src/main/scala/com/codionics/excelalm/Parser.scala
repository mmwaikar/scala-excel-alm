package com.codionics.excelalm

import com.typesafe.scalalogging.Logger

/**
  * Created by mmwaikar on 22-04-17.
  */
object Parser {
  val logger = Logger(Parser.getClass)

  def parseSrs(cellText: String): List[String] = {
    getParseFn(Constants.srsWithSpace, Constants.srsWithoutSpace)(cellText)
  }

  def parseSsrsLabeling(cellText: String): List[String] = {
    getParseFn(Constants.ssrsLabelingWithSpace, Constants.ssrsLabelingWithoutSpace)(cellText)
  }

  def parseSsrsSt(cellText: String): List[String] = {
    getParseFn(Constants.ssrsStWithSpace, Constants.ssrsStWithoutSpace)(cellText)
  }

  def parseSsrsIa(cellText: String): List[String] = {
    getParseFn(Constants.ssrsIaWithSpace, Constants.ssrsIaWithoutSpace)(cellText)
  }

  def parseSsrsAws(cellText: String): List[String] = {
    getParseFn(Constants.ssrsAwsWithSpace, Constants.ssrsAwsWithoutSpace)(cellText)
  }

  def parseSsrsAwp(cellText: String): List[String] = {
    getParseFn(Constants.ssrsAwpWithSpace, Constants.ssrsAwpWithoutSpace)(cellText)
  }

  def parseSsrsCcs(cellText: String): List[String] = {
    getParseFn(Constants.ssrsCcsWithSpace, Constants.ssrsCcsWithoutSpace)(cellText)
  }

  def parseSsrsPos(cellText: String): List[String] = {
    getParseFn(Constants.ssrsPosWithSpace, Constants.ssrsPosWithoutSpace)(cellText)
  }

  def parseSsrsIrap(cellText: String): List[String] = {
    getParseFn(Constants.ssrsIrapWithSpace, Constants.ssrsIrapWithoutSpace)(cellText)
  }

  def parseSsrsXray(cellText: String): List[String] = {
    getParseFn(Constants.ssrsXrayWithSpace, Constants.ssrsXrayWithoutSpace)(cellText)
  }

  def parseSsrsAwm(cellText: String): List[String] = {
    getParseFn(Constants.ssrsAwmWithSpace, Constants.ssrsAwmWithoutSpace)(cellText)
  }

  def parseSsrsCooling(cellText: String): List[String] = {
    getParseFn(Constants.ssrsCoolingWithSpace, Constants.ssrsCoolingWithoutSpace)(cellText)
  }

  def parseAll(cellText: String): List[String] = {
    val allSrs = parseSrs(cellText)
    val allSsrsLabeling = parseSsrsLabeling(cellText)
    val allSsrsSt = parseSsrsSt(cellText)
    val allSsrsIa = parseSsrsIa(cellText)
    val allSsrsAws = parseSsrsAws(cellText)
    val allSsrsAwp = parseSsrsAwp(cellText)
    val allSsrsCcs = parseSsrsCcs(cellText)
    val allSsrsPos = parseSsrsPos(cellText)
    val allSsrsIrap = parseSsrsIrap(cellText)
    val allSsrsXray = parseSsrsXray(cellText)
    val allSsrsAwm = parseSsrsAwm(cellText)
    val allSsrsCooling = parseSsrsCooling(cellText)

    val all = allSrs ++ allSsrsLabeling ++ allSsrsSt ++ allSsrsIa ++ allSsrsAws ++ allSsrsAwp ++
      allSsrsCcs ++ allSsrsPos ++ allSsrsIrap ++ allSsrsXray ++ allSsrsAwm ++ allSsrsCooling
    /**
      * NOTE: Since a Seq is lazy, the below logging statement materializes
      * the Seq, hence please don't remove it.
      */
    logger.debug(s"all count: ${all.size}")
    all toList
  }

  private def getParseFn(withSpace: String, withoutSpace: String) = (cellText: String) => {
    val patternWithoutSpace = withoutSpace.r
    val withoutSpaces = (patternWithoutSpace findAllIn cellText).toSeq
//    logger.debug(s"withoutSpaces: ${withoutSpaces.mkString(", ")}")

    val patternWithSpace = withSpace.r
    val withSpaces = (patternWithSpace findAllIn cellText).toSeq
//    logger.debug(s"withSpaces: ${withSpaces.mkString(", ")}")

    val all = withSpaces ++ withoutSpaces
    /**
      * NOTE: Since a Seq is lazy, the below logging statement materializes
      * the Seq, hence please don't remove it.
      */
    logger.debug(s"all for: ${all.mkString(", ")}")
    all toList
  }
}
