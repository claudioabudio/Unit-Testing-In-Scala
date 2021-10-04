package matchers

import com.h2.services.Currency
import org.scalatest.Inside

class PatternMatchingSpec extends UnitSpec with Inside {
    behavior of "Currency when pattern matching"

    it should "be able to assert on the values of the currency" in {
      val tenUsd : Currency = "10 USD"
      inside(tenUsd) {
        case Currency(code, amount, costInDollars) =>
              code should === ("USD")
              amount should === (10.0)
              costInDollars.amount should === (14)
      }

    }

  it should "be able to match pattern on the values of the currency" in {
    val tenUsd: Currency = "10 USD"
    tenUsd should matchPattern {
      case Currency(code, _, _ ) =>
    }
  }
}
