package com.codionics.excelalm

import com.typesafe.scalalogging.Logger

/**
  * Created by mmwaikar on 26-04-17.
  */
class ExampleRegexParserSpec extends BaseSpec {
  override val logger = Logger[ExampleRegexParserSpec]

  "A parser" should "parse SSRS IRAP" in {
//    val parseFn = ExampleRegexParser.getParseFn("(SSRS_IRAP|ssrs_irap): (\\d)+", "SSRS_IRAP:(\\d)+")
//    val parseFn = ExampleRegexParser.getParseFn("(S|s)(S|s)(R|r)(S|s)_(I|i)(R|r)(A|a)(P|p): (\\d)+", "SSRS_IRAP:(\\d)+")
    val parseFn = ExampleRegexParser.getParseFn("[a-zA-Z]{3,4}_[a-zA-Z]{2,8}( )*:( )*(\\d)+")
    testMixCase("SSRS_IRAP", parseFn)
  }
}
