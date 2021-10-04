package matchers

import com.h2.services.Currency

class ExceptionSpec extends UnitSpec {
    behavior of "Currency during exception condition"
    it should "throw an exception when invalid number provided" in {
      a [NumberFormatException] should be thrownBy Currency.stringToCurrency("Two USD")
      an [NumberFormatException] should be thrownBy Currency.stringToCurrency("Two USD")
    }

    it should "throw an exception with a detailed message when invalid number provided" in {
        val exception = the [NumberFormatException] thrownBy Currency.stringToCurrency("One USD")
        println(exception.getMessage)
      exception.getMessage should include ("One")
    }
}
