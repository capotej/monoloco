package com.twitter.monoloco


import com.twitter.monoloco.tricks.Tricks
import com.twitter.logging.{Logger, LoggerFactory, FileHandler}
import com.twitter.logging.config._
import scala.Some

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import sun.misc.Signal
import com.twitter.util.SignalHandler

object App extends Logging {

  val monkey = new DefaultMonkey(Tricks())

  val logHandler = FileHandler(filename = "logs/monoloco.log", rollPolicy = Policy.Daily)

  val config = new LoggerFactory(node = "monoloco",
    level = Some(Logger.INFO),
    handlers = List(logHandler))()

  val executorService = Executors.newSingleThreadScheduledExecutor()

  def main(args: Array[String]) {
    logger.info("starting monoloco")
    val initialDelay = 0
    val timeInterval = 1
    executorService.scheduleAtFixedRate(monkey, initialDelay, timeInterval, TimeUnit.SECONDS)
  }

}
