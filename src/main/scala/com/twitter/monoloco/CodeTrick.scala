package com.twitter.monoloco

abstract class CodeTrick extends Trick {

  def start()
  def stop()

  def execute() {
    start()
    sleepForDuration()
    stop()
  }

}
