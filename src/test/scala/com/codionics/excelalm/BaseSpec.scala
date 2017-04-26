package com.codionics.excelalm

import com.typesafe.scalalogging.Logger
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

/**
  * Created by mmwaikar on 22-04-17.
  */
class BaseSpec extends FlatSpec {
  val logger = Logger[BaseSpec]

  def getCellTextToMatch(withSpace: String, withoutSpace: String) = {
    s"I have an $withSpace and $withoutSpace in me"
  }

  def getStringsToFind(toFind: String) = Array(toFind + ": 123", toFind + ":3456")

  def test(prefix: String, parseFn: String => Seq[String]) = {
    val arr = getStringsToFind(prefix)
    val cellText = getCellTextToMatch(arr(0), arr(1))
    logger.debug(s"cellText: $cellText")

    val strings = parseFn(cellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
  }

  def getMixedCaseStringsToFind(toFind: String) = {
    val lowerColonSpace = toFind.toLowerCase + ": 123"
    val lowerColonNoSpace = toFind.toLowerCase + ":3456"
    val capitalLowerColonSpace = lowerColonSpace .capitalize
    val capitalLowerColonNoSpace = lowerColonNoSpace.capitalize

    Array(toFind + ": 123", toFind + ":3456", lowerColonSpace, lowerColonNoSpace, capitalLowerColonSpace,
      capitalLowerColonNoSpace, "SSRS_Irap:1", "ssRs_IrAp: 987")
  }

  def testMixCase(prefix: String, parseFn: String => Seq[String]) = {
    val arr = getMixedCaseStringsToFind(prefix)
    val cellText = s"I have ${arr.mkString("  ,  ")} in me"
    logger.debug(s"cellText: $cellText")

    val strings = parseFn(cellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
    strings.size should be (arr.size)
  }
}
