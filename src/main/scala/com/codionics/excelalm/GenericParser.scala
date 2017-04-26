package com.codionics.excelalm

import com.typesafe.scalalogging.Logger

/**
  * Created by mmwaikar on 26-04-17.
  */
object GenericParser {
  val logger = Logger(GenericParser.getClass)

  def parse(cellText: String): List[String] = {
    val pattern = "[a-zA-Z]{3,4}_[a-zA-Z]{2,8}( )*:( )*(\\d)+".r
    val matched = (pattern findAllIn cellText).toList
    //    logger.debug(s"matched: ${matched.mkString(", ")}")
    matched
  }
}
