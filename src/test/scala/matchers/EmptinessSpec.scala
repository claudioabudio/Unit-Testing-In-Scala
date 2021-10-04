package matchers

import com.h2.services.{Currency, CustomerService}

class EmptinessSpec extends UnitSpec {
    behavior of "Customer for emptiness"

    val customerService : CustomerService = new CustomerService() {}

    it should "return empty for the customer's last name" in {
      val (first, last, email, dateOfBirth) = ("clau", "", "clau.abu@xxx.com", "1980/06/28")
      val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
      val customer = customerService.getCustomer(customerId).get
      customer.last should be (empty)
    }

    it should "return empty for an empty wallet with no currencies" in {
      val wallet : List[Currency] = List()
      wallet should be (empty)
    }

  it should "return non empty for a non empty wallet with some currencies" in {
    val wallet : List[Currency] = List(Currency.stringToCurrency("1 USD"))
    wallet should not be (empty)
  }
}
