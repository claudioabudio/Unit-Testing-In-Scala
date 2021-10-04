package matchers

import com.h2.services.Currency

class ContainerSpec extends UnitSpec {
  behavior of "Currencies in a wallet"

  it should "contain a currency that was added to a List" in {
      val tenUsd : Currency = "10 USD"
      val fiveCan : Currency = "5 CAD"
      val hundredEuros : Currency = "100 EUR"

      val wallet = List(tenUsd, fiveCan, hundredEuros)

      wallet should contain (tenUsd)
  }

  it should "not contain a currency that was not added to a List" in {
    val tenUsd : Currency = "10 USD"
    val fiveCan : Currency = "5 CAD"
    val hundredEuros : Currency = "100 EUR"
    val oneNzd : Currency = "1 NZD"

    val wallet = List(tenUsd, fiveCan, hundredEuros)

    wallet should not contain (oneNzd)
  }

  it should "contain a currency that was added to a Set" in {
    val tenUsd : Currency = "10 USD"
    val fiveCan : Currency = "5 CAD"
    val hundredEuros : Currency = "100 EUR"

    val wallet = Set(tenUsd, fiveCan, hundredEuros)

    wallet should contain (tenUsd)
  }

  it should "contain a currency that was added to a Map" in {
    val tenUsd : Currency = "10 USD"
    val fiveCan : Currency = "5 CAD"
    val hundredEuros : Currency = "100 EUR"

    val wallet : Map[String, Currency] = Map("USD" -> tenUsd
            , "CAD" -> fiveCan
            ,"EUR" -> hundredEuros)

    wallet should contain ("USD" -> tenUsd)
  }

  it should "contain at least one of a currency that was added to a Set" in {
    val tenUsd : Currency = "10 USD"
    val fiveCan : Currency = "5 CAD"
    val hundredEuros : Currency = "100 EUR"
    val fifteenRupees : Currency = "15 INR"

    val wallet = Set(tenUsd, tenUsd, fiveCan, hundredEuros)

    wallet should contain oneOf (tenUsd, fifteenRupees)
    wallet should contain oneElementOf List(tenUsd, fifteenRupees)
  }

  it should "contain none of a currency that was added to a Set" in {
    val tenUsd : Currency = "10 USD"
    val fiveCan : Currency = "5 CAD"
    val hundredEuros : Currency = "100 EUR"
    val fifteenRupees : Currency = "15 INR"

    val wallet = Set( fiveCan, hundredEuros)

    wallet should contain noneOf (tenUsd, fifteenRupees)
    wallet should contain noElementsOf List(tenUsd, fifteenRupees)

  }
}
