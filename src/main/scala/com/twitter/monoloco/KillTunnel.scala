package com.twitter.monoloco

class KillTunnel extends Trick {

  def duration() = 30000 * 4 //2 minutes

  def start() = {
    "monit stop autossh"
  }

  def stop() = {
    "monit start autossh"
  }

}
