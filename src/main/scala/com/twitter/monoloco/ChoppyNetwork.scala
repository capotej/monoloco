package com.twitter.monoloco

class ChoppyNetwork extends Trick {

  def duration() = 30000

  def start() = {
    "tc qdisc change dev eth0 root netem loss 0.3% 25%"
  }

  def stop() = {
    "tc qdisc change dev eth0 root netem loss 0.0% 0%"
  }
}
