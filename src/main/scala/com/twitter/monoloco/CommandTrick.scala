package com.twitter.monoloco

import org.apache.commons.exec.CommandLine
import org.apache.commons.exec.DefaultExecutor

abstract class CommandTrick extends Trick {

  def start(): String
  def stop(): String

  def execute() {
    val startLine = CommandLine.parse(start())
    val stopLine = CommandLine.parse(stop())
    val executor = new DefaultExecutor()
    try {
      executor.execute(startLine)
      sleepForDuration()
      executor.execute(stopLine)
    } catch {
      case e:Exception => logger.error(e, "couldnt run cmd, aborting trick")
    }
  }


}
