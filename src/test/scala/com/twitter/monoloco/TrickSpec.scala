package com.twitter.monoloco.test

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, FunSpec}
import org.scalatest.matchers.{ShouldMatchers, MustMatchers}

@RunWith(classOf[JUnitRunner])
class TrickSpec extends FlatSpec with ShouldMatchers {

  "trick test" should "work" in {
      "2" should equal("2")
  }

}
