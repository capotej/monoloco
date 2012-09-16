package com.twitter.monoloco

import util.Random

class DefaultMonkey(val tricks: List[Trick]) extends Monkey {

  require(!tricks.isEmpty, "Trick collection cannot be empty")

  def shouldRun() = {
    val rand = new Random(System.currentTimeMillis())
    val res = rand.nextInt(200) == 5
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
