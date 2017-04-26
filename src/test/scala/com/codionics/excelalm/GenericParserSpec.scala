package com.codionics.excelalm

import com.typesafe.scalalogging.Logger
import org.scalatest.Matchers._

/**
  * Created by mmwaikar on 26-04-17.
  */
class GenericParserSpec extends BaseSpec {
  override val logger = Logger[GenericParserSpec]

  "A generic parser" should "parse all" in {
    val arrStrs = Constants.stringsToFind map getStringsToFind
    val cellTexts = arrStrs.map(arr => getCellTextToMatch(arr(0), arr(1)))
    val combinedCellText = cellTexts.mkString(System.lineSeparator())
    logger.debug(s"combinedCellText: $combinedCellText")

    val strings = GenericParser.parse(combinedCellText)
    logger.debug(s"Found: $strings")
    strings should not be empty
  }
}
