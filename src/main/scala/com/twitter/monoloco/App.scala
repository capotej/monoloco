package com.twitter.monoloco

import java.util.Timer
import com.twitter.logging.{Logger, LoggerFactory, FileHandler}
import com.twitter.logging.config._
import scala.Some

object App extends Logging {

  val logHandler = FileHandler(filename = "logs/monoloco.log", rollPolicy = Policy.Daily)
  val config = new LoggerFactory(node = "monoloco",
    level = Some(Logger.INFO),
    handlers = List(logHandler))()

  def main(args: Array[String]) {
    logger.info("starting monoloco")

    val monkey = DefaultMonkey
    val timer = new Timer()
    timer.schedule(new Worker(monkey), 0, 1000)
  }

}
