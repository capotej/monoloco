package com.twitter.monoloco.test

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSpec
import org.scalatest.matchers.MustMatchers

@RunWith(classOf[JUnitRunner])
class TrickSpec extends FunSpec with MustMatchers {

  describe("trick test") {
    it("should execute") {
      "2" must equal("2")
    }
  }

}
