package fixtures

import com.h2.entities.Customer
import com.h2.services.CustomerService
import matchers.UnitSpec
import org.scalatest.BeforeAndAfterAll

class BeforeAndAfterAllSpec extends UnitSpec with BeforeAndAfterAll {
    var customers : List[Customer] = List.empty

    override def beforeAll(): Unit = {
        info("initializing list of customers...")
        val customerService = new CustomerService {}
        val customerId1 = customerService.createNewCustomer(first= "clau",last = "abu", email= "clau.abu@xxx.com", dateOfBirth="1980/06/28")
        val customerId2 = customerService.createNewCustomer(first= "maria",last = "abu", email= "maria.abu@xxx.com", dateOfBirth="1980/06/28")
        customers = List(customerId1, customerId2).map(id => customerService.getCustomer(id).get).toList
    }

    override def afterAll(): Unit = {
        info("emptying list of customers...")
        customers = List.empty
    }

    behavior of "Customer using BeforeAndAfterAllTrai"
    it should "report only 2 customers in List" in {
        customers should have size (2)
    }

    it should "report email address should include .com" in {
        customers.map(customer => customer.email.toString should include(".com"))
    }
}
