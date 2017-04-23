package com.codionics.excelalm

import scala.collection.mutable.ListBuffer

/**
  * Created by mmwaikar on 23-04-17.
  */
case class InterimData (risk: String, rcms: Seq[String])

object InterimData {
//  def apply(risk: String, rcms: Seq[String], clean: Boolean = true): InterimData = {
//    if (clean) {
//      val buffer = ListBuffer[String]()
//
//      rcms.map(rcm => {
//        Constants.stringsToFind.map(s => {
//          val sToFind = s + ":"
//          if (rcm.contains(sToFind)) {
//            buffer += rcm.replace(sToFind, "").trim
//          }
//        })
//      })
//
//      new InterimData(risk, buffer)
//    } else {
//      new InterimData(risk, rcms)
//    }
//  }

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
