package com.twitter.monoloco

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.matchers.MustMatchers

@RunWith(classOf[JUnitRunner])
class MonkeySpec extends FunSpec with MockitoSugar with MustMatchers {

   describe("DefaultMonkey doesn't accept an empty Trick List") {
      intercept[IllegalArgumentException] {
         new DefaultMonkey(List())
      }
    }
    
    describe("one call only once") {
      val trickMock = mock[Trick]      
      
      val monkey = new DefaultMonkey(List(trickMock))
      monkey.apply()
            
      verify(trickMock).execute()
    }
}
