package com.codionics.excelalm

import org.scalatest.FlatSpec

/**
  * Created by mmwaikar on 22-04-17.
  */
class BaseSpec  extends FlatSpec {
  def getCellTextToMatch(withSpace: String, withoutSpace: String) = {
    s"I have an $withSpace and $withoutSpace in me"
  }

  def getStringsToFind(toFind: String) = Array(toFind + ": 123", toFind + ":3456")
}
