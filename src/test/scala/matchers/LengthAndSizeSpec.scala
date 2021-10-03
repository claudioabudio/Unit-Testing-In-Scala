package matchers

import com.h2.services.CustomerService

import java.util.UUID

class LengthAndSizeSpec extends UnitSpec {
  val customerService : CustomerService = new CustomerService() {}

  behavior of "Customer service for length"

  it should "customer first name length correctly matches using should have length matcher" in {
    val (first, last, email, dateOfBirth) = ("clau", "abu", "clau.abu@xxx.com", "1980/06/28")
    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get
    customer.first should have length first.length
  }

  it should "customer ids list should have a size of 2" in {

    val customers : Seq[(String, String, String, String)] = List(("clau", "abu", "clau.abu@xxx.com", "1980/06/28"),
      ("maria", "collar", "maria.collar@xxx.com", "1975/08/30"))
    val customerIds : Seq[UUID] = customers.map(customer => customerService.createNewCustomer(customer._1, customer._2, customer._3, customer._4))
    customerIds should have size 2
  }
}
