package com.codionics.excelalm

import scala.collection.mutable.ListBuffer

/**
  * Created by mmwaikar on 23-04-17.
  */
case class InterimData (risk: String, rcms: Seq[String])

object InterimData {

  def clean(rcms: Seq[String]): Seq[String] = {
    val buffer = ListBuffer[String]()

    rcms.map(rcm => {
      Constants.stringsToFind.map(s => {
        val sToFind = s + ":"
        if (rcm.contains(sToFind)) {
          buffer += rcm.replace(sToFind, "").trim
        }
      })
    })

    buffer
  }
}
