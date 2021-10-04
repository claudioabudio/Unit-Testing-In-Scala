package fixtures

import com.h2.services.Currency
import matchers.UnitSpec

class ScalaFixtureSpec extends UnitSpec {

  def fixture = new {
    val currency1 : Currency = "10 USD"
    val currency2 : Currency = "10 USD"
  }

  behavior of "Currency Equals"
  it should "match two 10 Usd currencies as equal when using the should equal matchers" in {
    fixture.currency1 should equal (fixture.currency2)
  }

  it should "match two 10 Usd currencies as equal when using the should be matchers" in {
    fixture.currency1 should be (fixture.currency2)
  }

  it should "match two 10 Usd currencies as equal when using the should === matchers" in {
    fixture.currency1 should === (fixture.currency2)
  }

  it should "match two 10 Usd currencies as equal when using the shouldEqual matchers" in {
    fixture.currency1 shouldEqual fixture.currency2
  }


}
