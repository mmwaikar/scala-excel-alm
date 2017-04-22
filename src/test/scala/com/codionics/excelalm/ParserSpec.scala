package com.codionics.excelalm

import com.typesafe.scalalogging.Logger
import org.scalatest.Matchers._
import com.codionics.excelalm.Constants._

/**
  * Created by mmwaikar on 22-04-17.
  */
class ParserSpec extends BaseSpec {
  val logger = Logger[ParserSpec]

  val stringsToFind = Array("SRS", "SSRS_Labeling", "SSRS_ST", "SSRS_AWS",
    "SSRS_AWP", "SSRS_CCS", "SSRS_Pos", "SSRS_IRAP", "SSRS_XRAY",
    "SSRS_AWM", "SSRS_Cooling")

  "A parser" should "parse SRS" in {
    test("SRS", Parser.parseSrs)
  }

  it should "parse SSRS Labeling" in {
    test("SSRS_Labeling", Parser.parseSsrsLabeling)
  }

  it should "parse SSRS ST" in {
    test("SSRS_ST", Parser.parseSsrsSt)
  }

  it should "parse SSRS AWS" in {
    test("SSRS_AWS", Parser.parseSsrsAws)
  }

  it should "parse SSRS AWP" in {
    test("SSRS_AWP", Parser.parseSsrsAwp)
  }

  it should "parse SSRS CCS" in {
    test("SSRS_CCS", Parser.parseSsrsCcs)
  }

  it should "parse SSRS Pos" in {
    test("SSRS_Pos", Parser.parseSsrsPos)
  }

  it should "parse SSRS IRAP" in {
    test("SSRS_IRAP", Parser.parseSsrsIrap)
  }

  it should "parse SSRS XRAY" in {
    test("SSRS_XRAY", Parser.parseSsrsXray)
  }

  it should "parse SSRS AWM" in {
    test("SSRS_AWM", Parser.parseSsrsAwm)
  }

  it should "parse SSRS Cooling" in {
    test("SSRS_Cooling", Parser.parseSsrsCooling)
  }

  it should "parse all" in {
    val arrStrs = stringsToFind map getStringsToFind
    val cellTexts = arrStrs.map(arr => getCellTextToMatch(arr(0), arr(1)))
    val combinedCellText = cellTexts.mkString(System.lineSeparator())
    logger.debug(s"combinedCellText: $combinedCellText")

    val strings = Parser.parseAll(combinedCellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
  }

  private def test(prefix: String, parseFn: String => Seq[String]) = {
    val arr = getStringsToFind(prefix)
    val cellText = getCellTextToMatch(arr(0), arr(1))
    logger.debug(s"cellText: $cellText")

    val strings = parseFn(cellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
  }
}
