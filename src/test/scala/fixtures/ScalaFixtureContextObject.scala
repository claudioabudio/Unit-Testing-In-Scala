package fixtures

import com.h2.entities.{Customer, Deposits, Dollars}
import com.h2.services.{CustomerService, ProductService}
import matchers.UnitSpec

import java.util.UUID

class ScalaFixtureContextObject extends UnitSpec {
  trait ACustomer {
    private val service: CustomerService = new CustomerService {}
    private val customerId: UUID = service.createNewCustomer(first = "nancy", last= "williams"
      , email= "nancy@google.com", dateOfBirth = "1982/06/20")
    val customer: Customer = service.getCustomer(customerId).get
  }

  trait AProduct {
    private val service: ProductService = new ProductService {}
    private val productId: UUID = service.addNewDepositProduct(name = "CoreChecking", minBalance = 2000, ratePerYear = 0.02, transactionsAllowedPerMonth = 10)
    val product: Deposits = service.getDepositProduct(productId).get
  }

  trait ADollars {
    val fiveThousandDollars = Dollars(5000)
  }
  behavior of "ACustomer"
  it should "return a customer with non empty email address" in new ACustomer {
    customer.email.toString should not be empty
  }

  behavior of "AProduct"
  it should "return a product with more than 1000 dollars minimum requirement" in new AProduct {
    product.minimumBalancePerMonth should be >= Dollars(1000)
  }

  behavior of "AProduct with some money"
  it should "return true for a product with 5000 dollars greater than then minimum requirement" in new ADollars with AProduct {
    fiveThousandDollars should be > product.minimumBalancePerMonth
  }
}
