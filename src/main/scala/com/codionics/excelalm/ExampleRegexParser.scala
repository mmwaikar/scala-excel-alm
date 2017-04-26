package com.codionics.excelalm

/**
  * Created by mmwaikar on 26-04-17.
  */
object ExampleRegexParser {

  def getParseFn(regexString: String) = (cellText: String) => {
    val patternWithSpace = regexString.r
    val matched = (patternWithSpace findAllIn cellText).toSeq
    //    logger.debug(s"matched: ${matched.mkString(", ")}")

    /**
      * NOTE: Since a Seq is lazy, the below logging statement materializes
      * the Seq, hence please don't remove it.
      */
    //    logger.debug(s"all for: ${all.mkString(", ")}")
    matched toList
  }

  def getParseFn(withSpace: String, withoutSpace: String) = (cellText: String) => {
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
    //    logger.debug(s"all for: ${all.mkString(", ")}")
    all toList
  }
}
