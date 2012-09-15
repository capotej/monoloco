package com.twitter.monoloco.com.twitter.monoloco.tricks

import java.util.concurrent.TimeUnit.MINUTES
import com.twitter.monoloco.Trick

class KillTunnel extends Trick {

  def duration() = (2L, MINUTES)

  def start() = {
    "monit stop autossh"
  }

  def stop() = {
    "monit start autossh"
  }

}
