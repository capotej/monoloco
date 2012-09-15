package com.twitter.monoloco.tricks

import java.util.concurrent.TimeUnit.MINUTES
import com.twitter.monoloco.CommandTrick

class KillTunnel extends CommandTrick {

  def duration() = (2L, MINUTES)

  def start() = {
    "monit stop autossh"
  }

  def stop() = {
    "monit start autossh"
  }

}
