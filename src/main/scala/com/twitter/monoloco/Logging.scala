package com.twitter.monoloco

import com.twitter.logging.Logger

trait Logging {
  val logger = Logger.get("monoloco")

}
