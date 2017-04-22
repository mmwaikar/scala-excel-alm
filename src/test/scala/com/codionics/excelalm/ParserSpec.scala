package com.codionics.excelalm

import com.typesafe.scalalogging.Logger
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

/**
  * Created by mmwaikar on 22-04-17.
  */
class ParserSpec extends FlatSpec {
  val logger = Logger[ParserSpec]
  val cellText = "I have an SRS: 123 and SSRS_Labeling: 23456 in me"

  "A parser" should "parse SRS" in {
    val strings = Parser.parse(cellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
  }
}
