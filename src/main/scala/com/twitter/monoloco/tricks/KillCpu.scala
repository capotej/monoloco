package com.twitter.monoloco.tricks

import java.util.concurrent.TimeUnit.SECONDS
import com.twitter.monoloco.CodeTrick

class KillCpu extends CodeTrick {

  def duration() = (20L, SECONDS)

  def start() {
    logger.info("doing it")
  }

  def stop() {
    logger.info("done it")
  }


}
