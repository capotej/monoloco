package com.twitter.monoloco

import com.twitter.logging.{Logger, LoggerFactory, FileHandler}
import com.twitter.logging.config._
import scala.Some

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

object App extends Logging {

  val logHandler = FileHandler(filename = "logs/monoloco.log", rollPolicy = Policy.Daily)

  val config = new LoggerFactory(node = "monoloco",
    level = Some(Logger.INFO),
    handlers = List(logHandler))()

  val executorService = Executors.newSingleThreadScheduledExecutor()

  def main(args: Array[String]) {
    logger.info("starting monoloco")    

    val monkey = DefaultMonkey
    val initialDelay = 0
    val timeInterval = 1

    executorService.scheduleAtFixedRate(monkey, initialDelay, timeInterval, TimeUnit.SECONDS)

  }

}
