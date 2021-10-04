package matchers

import com.h2.services.CustomerService

class ObjectIdentitySpec extends UnitSpec {
  val customerService : CustomerService = new CustomerService() {}

  behavior of "Customer service for Object Identity"
  it should "correctly match the customer email starting with first name" in {
    val (first, last, email, dateOfBirth) = ("clau", "abu", "clau.abu@xxx.com", "1980/06/28")
    val customerId1 = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customerId2 = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer1 = customerService.getCustomer(customerId1).get
    val customer2 = customerService.getCustomer(customerId2).get
    customer1 should be theSameInstanceAs (customer2)
  }
}
