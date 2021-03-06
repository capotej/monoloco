package com.twitter.monoloco.tricks

import java.util.concurrent.TimeUnit.SECONDS
import com.twitter.monoloco.CommandTrick

class ChoppyNetwork extends CommandTrick {

  def duration() = (30L, SECONDS)

  def start() = {
    "tc qdisc change dev eth0 root netem loss 0.3% 25%"
  }

  def stop() = {
    "tc qdisc change dev eth0 root netem loss 0.0% 0%"
  }
}
