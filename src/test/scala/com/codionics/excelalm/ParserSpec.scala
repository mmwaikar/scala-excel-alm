package com.codionics.excelalm

import com.typesafe.scalalogging.Logger
import org.scalatest.Matchers._
import com.codionics.excelalm.Constants._

/**
  * Created by mmwaikar on 22-04-17.
  */
class ParserSpec extends BaseSpec {
  val logger = Logger[ParserSpec]
//  val cellText = "I have an SRS: 123 and SSRS_Labeling: 23456 in me"

  "A parser" should "parse SRS" in {
    val cellText = getCellTextToMatch("SRS: 123", "SRS:3456")
    logger.debug(s"cellText: $cellText")

    val strings = Parser.parseSrs(cellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
  }
}
