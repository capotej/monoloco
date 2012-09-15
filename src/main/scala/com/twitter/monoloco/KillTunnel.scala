package com.twitter.monoloco

import java.util.concurrent.TimeUnit.MINUTES

class KillTunnel extends Trick {

  def duration() = (2L, MINUTES)

  def start() = {
    "monit stop autossh"
  }

  def stop() = {
    "monit start autossh"
  }

}
