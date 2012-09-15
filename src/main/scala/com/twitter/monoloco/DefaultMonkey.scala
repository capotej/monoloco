package com.twitter.monoloco

import tricks.{KillCpu, KillTunnel}
import util.Random

class DefaultMonkey(tricks: List[Trick]) extends Monkey {

  def shouldRun() = {
    val rand = new Random(System.currentTimeMillis())
    val res = rand.nextInt(50) == 5
    if (res) logger.info("monkey is pissed!")
    res
  }

  def apply() {
    val rand = new Random(System.currentTimeMillis())
    val random_index = rand.nextInt(tricks.length)
    val result = tricks(random_index)
    result()
  }

}
