package com.twitter.monoloco

abstract class Monkey extends Runnable with Logging {

  //gets run every second
  final def execute() {
    if (shouldRun()) apply()
  }
  
  final def run() = this.execute()

  //shouldRun
  def shouldRun():Boolean

  //gets run if shouldRun is true
  def apply()

}
