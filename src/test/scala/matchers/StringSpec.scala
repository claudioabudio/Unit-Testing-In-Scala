package matchers

import com.h2.services.CustomerService

class StringSpec extends UnitSpec {
  val customerService : CustomerService = new CustomerService() {}

  behavior of "Customer service for Strings"
  it should "correctly match the customer email starting with first name" in {
      val (first, last, email, dateOfBirth) = ("clau", "abu", "clau.abu@xxx.com", "1980/06/28")
      val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
      val customer = customerService.getCustomer(customerId).get
      customer.email.toString should startWith (first)
  }

  it should "correctly match the customer email ending with '.com' " in {
    val (first, last, email, dateOfBirth) = ("clau", "abu", "clau.abu@xxx.com", "1980/06/28")
    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get
    customer.email.toString should endWith (".com")
  }

  it should "correctly match the customer email includes the '@' symbol " in {
    val (first, last, email, dateOfBirth) = ("clau", "abu", "clau.abu@xxx.com", "1980/06/28")
    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get
    customer.email.toString should include ("@")
  }

  it should "correctly match the customer email as regular expression " in {
    val (first, last, email, dateOfBirth) = ("clau", "abu", "clau.abu@com", "1980/06/28")
    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get
    customer.email.toString should include regex "[a-zA-Z]+.[a-zA-Z]+[@.]com"
  }

  it should "correctly match the customer dateOfBirth fullyMatch regular expression " in {
    val (first, last, email, dateOfBirth) = ("clau", "abu", "clau.abu@com", "1980/06/28")
    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get
    customer.dateOfBirth.toString should fullyMatch regex "[0-9]{4}-[0-9]{2}-[0-9]{2}"
  }

}
