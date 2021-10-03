package matchers

import com.h2.services.Currency

class EqualitySpec extends UnitSpec {
  behavior of "Currency Equals"
  it should "match two 10 Usd currencies as equal when using the should equal matchers" in {
    val currency1 : Currency = "10 USD"
    val currency2 : Currency = "10 USD"

    currency1 should equal (currency2)
  }

  it should "match two 10 Usd currencies as equal when using the should be matchers" in {
    val currency1 : Currency = "10 USD"
    val currency2 : Currency = "10 USD"

    currency1 should be (currency2)
  }

  it should "match two 10 Usd currencies as equal when using the should === matchers" in {
    val currency1 : Currency = "10 USD"
    val currency2 : Currency = "10 USD"

    currency1 should === (currency2)
  }

  it should "match two 10 Usd currencies as equal when using the shouldEqual matchers" in {
    val currency1 : Currency = "10 USD"
    val currency2 : Currency = "10 USD"

    currency1 shouldEqual currency2
  }

  it should "match two 10 Usd currencies as equal when using the shouldBe matchers" in {
    val currency1 : Currency = "10 USD"
    val currency2 : Currency = "10 USD"

    currency1 shouldBe currency2
  }

}
