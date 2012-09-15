package com.twitter.monoloco

abstract class Monkey extends Runnable with Logging {

  @volatile var count = 0L

  //gets run every second
  final def run() = {
     if (shouldRun()) {
        apply()
        count += 1L
     }
  }

  //shouldRun
  def shouldRun():Boolean

  //gets run if shouldRun is true
  def apply()
  
  def executions() = count

}
