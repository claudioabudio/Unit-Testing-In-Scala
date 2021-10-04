package fixtures

import com.h2.services.Currency
import fixtures.RandomCurrencies.{currencies, currencyCodes, random}
import matchers.UnitSpec
import org.scalatest.BeforeAndAfter

import scala.util.Random

class BeforeAndAfterSpec extends UnitSpec with BeforeAndAfter {
  private val random = new Random
  private var currencies: List[Currency] = List.empty
  private val currencyCodes = List("CAD", "USD", "EUR", "SGD")

  before {
    info("adding random currencies to currencies list...")
    currencies = (1 to random.between(100, 201)).map(_ => {
      val randomAmount = random.between(10, 101)
      val randomCurrencyCode = currencyCodes(random.between(0, currencyCodes.length))
      val currency: Currency = s"$randomAmount $randomCurrencyCode"
      currency
    }).toList
  }

  after {
    info("removing currencies from currencies list...")
    currencies = List.empty
  }

  behavior of "Testing Random Currencies with Loan Pattern"
  it should "have a total dollar cost > 10 dollars" in {
      currencies.map(_.costInDollars.amount).sum should be > 10
  }

  it should "not have any currency with code INR or NZD" in {
      currencies should contain noneOf ("INR", "NZD")
  }

}
