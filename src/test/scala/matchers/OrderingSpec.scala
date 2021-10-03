package matchers

import com.h2.services.Currency

class OrderingSpec extends UnitSpec {
  behavior of "Currency conversion cost in comparison"

  it should "match two 10 Usd currencies as greater or equal when using the should be matchers" in {
    val currency1 : Currency = "10 USD"
    val currency2 : Currency = "10 USD"

    currency1.amount should be >= currency2.amount
  }

  it should "match 100 Usd currencies as greater or equal than 10 USD using the should be matchers" in {
    val currency1 : Currency = "100 USD"
    val currency2 : Currency = "10 USD"

    currency1.costInDollars.amount should be >= currency2.costInDollars.amount
  }

  it should "report 1 USD less than 10 USD using the should be matchers" in {
    val currency1 : Currency = "1 USD"
    val currency2 : Currency = "10 USD"

    currency1.costInDollars.amount should be < currency2.costInDollars.amount
  }

  it should "report NZD less than USD (Lexicographic order)" in {
    "NZD" should be < "USD"
  }
}
