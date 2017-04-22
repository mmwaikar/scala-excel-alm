package com.codionics.excelalm

import com.typesafe.scalalogging.Logger
import org.scalatest.Matchers._
import com.codionics.excelalm.Constants._

/**
  * Created by mmwaikar on 22-04-17.
  */
class ParserSpec extends BaseSpec {
  val logger = Logger[ParserSpec]

  "A parser" should "parse SRS" in {
    test("SRS: 123", "SRS:3456", Parser.parseSrs)
//    val cellText = getCellTextToMatch("SRS: 123", "SRS:3456")
//    logger.debug(s"cellText: $cellText")
//
//    val strings = Parser.parseSrs(cellText)
//    logger.debug(s"Found: $strings")
//    strings should not be empty
  }

  it should "parse SSRS Labeling" in {
    test("SSRS_Labeling: 123", "SSRS_Labeling:3456", Parser.parseSsrsLabeling)
  }

  it should "parse SSRS ST" in {
    test("SSRS_ST: 123", "SSRS_ST:3456", Parser.parseSsrsSt)
  }

  it should "parse SSRS AWS" in {
    test("SSRS_AWS: 123", "SSRS_AWS:3456", Parser.parseSsrsAws)
  }

  it should "parse SSRS AWP" in {
    test("SSRS_AWP: 123", "SSRS_AWP:3456", Parser.parseSsrsAwp)
  }

  it should "parse SSRS CCS" in {
    test("SSRS_CCS: 123", "SSRS_CCS:3456", Parser.parseSsrsCcs)
  }

  it should "parse SSRS Pos" in {
    test("SSRS_Pos: 123", "SSRS_Pos:3456", Parser.parseSsrsPos)
  }

  it should "parse SSRS IRAP" in {
    test("SSRS_IRAP: 123", "SSRS_IRAP:3456", Parser.parseSsrsIrap)
  }

  it should "parse SSRS XRAY" in {
    test("SSRS_XRAY: 123", "SSRS_XRAY:3456", Parser.parseSsrsXray)
  }

  it should "parse SSRS AWM" in {
    test("SSRS_AWM: 123", "SSRS_AWM:3456", Parser.parseSsrsAwm)
  }

  it should "parse SSRS Cooling" in {
    test("SSRS_Cooling: 123", "SSRS_Cooling:3456", Parser.parseSsrsCooling)
  }

  private def test(withSpace: String, withoutSpace: String, parseFn: String => Seq[String]) = {
    val cellText = getCellTextToMatch(withSpace, withoutSpace)
    logger.debug(s"cellText: $cellText")

    val strings = parseFn(cellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
  }
}
