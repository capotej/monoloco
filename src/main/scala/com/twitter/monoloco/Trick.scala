package com.twitter.monoloco

import java.util.concurrent.TimeUnit

abstract class Trick extends Logging {

  val (time, unit) = duration()

  def duration():(Long, TimeUnit)

  def sleepForDuration() {
    unit.sleep(time)
  }

  def apply() {
    logger.info("starting: [%s] for %d %s", this, time, unit)
    execute()
    logger.info("stopping: [%s]", this)
  }

  def execute()

}
