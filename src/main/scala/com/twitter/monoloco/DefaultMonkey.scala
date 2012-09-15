package com.twitter.monoloco

import tricks.{KillCpu, KillTunnel}
import util.Random

object DefaultMonkey extends Monkey {

  def bagOfTricks():List[Trick] = {
    List[Trick](new KillTunnel)
  }

  def shouldRun() = {
    val rand = new Random(System.currentTimeMillis())
    val res = rand.nextInt(50) == 5
    if (res) logger.info("monkey is pissed!")
    res
  }

  def apply() {
    val rand = new Random(System.currentTimeMillis())
    val random_index = rand.nextInt(bagOfTricks().length)
    val result = bagOfTricks()(random_index)
    result()
  }

}
