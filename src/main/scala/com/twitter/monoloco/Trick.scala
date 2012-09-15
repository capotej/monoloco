package com.twitter.monoloco

import org.apache.commons.exec.CommandLine
import org.apache.commons.exec.DefaultExecutor
import java.util.concurrent.TimeUnit

abstract class Trick extends Logging {

  def start():String

  def stop():String

  def duration():(Long, TimeUnit)

  def apply() {
    val startLine = CommandLine.parse(start())
    val stopLine = CommandLine.parse(stop())
    val executor = new DefaultExecutor()
    logger.info("starting %s for %d milliseconds", start(), duration())
    try {
      executor.execute(startLine)

      val (time, unit) = duration()
      unit.sleep(time)

      logger.info("stopping: %s", stop())
      executor.execute(stopLine)
    } catch {
      case e:Exception => logger.error(e, "couldnt run cmd, aborting trick")
    }
  }

}
