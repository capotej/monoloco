package com.twitter.monoloco.tricks

import com.twitter.monoloco.Trick

object Tricks {

  def apply() = {
    List[Trick](new BurnCpu)
  }

}
