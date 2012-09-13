package com.twitter.monoloco

abstract class Monkey extends Logging {

  //gets run every second
  def execute() {
    if(shouldRun()) apply()
  }

  //shouldRun
  def shouldRun():Boolean

  //gets run if shouldRun is true
  def apply()

}
