package com.twitter.monoloco

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, FunSpec}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.matchers.{ShouldMatchers, MustMatchers}
import com.twitter.logging.{Logger, LoggerFactory, FileHandler}
import com.twitter.logging.config._
import scala.Some

@RunWith(classOf[JUnitRunner])
class MonkeySpec extends FlatSpec with MockitoSugar with ShouldMatchers {

  "DefaultMonkey" should "not accept an empty Trick List" in  {
    intercept[IllegalArgumentException] {
      new DefaultMonkey(List())
    }
  }

  "DefaultMonkey" should "only call once" in {
    val trickMock = mock[Trick]

    val monkey = new DefaultMonkey(List(trickMock))
    monkey.apply()

    verify(trickMock).apply()
  }
}
