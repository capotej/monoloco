package com.twitter.monoloco

import java.util.concurrent.TimeUnit.SECONDS

class ChoppyNetwork extends Trick {

  def duration() = (3L, SECONDS)

  def start() = {
    "tc qdisc change dev eth0 root netem loss 0.3% 25%"
  }

  def stop() = {
    "tc qdisc change dev eth0 root netem loss 0.0% 0%"
  }
}
