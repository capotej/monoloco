package com.twitter.monoloco

import java.util.TimerTask

class Worker(val monkey: Monkey) extends TimerTask {

  def run() {
    monkey.execute()
  }

}
