package assertions

import com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarSpec extends AnyFlatSpec {
  behavior of "a Dollar"
  it should "create the correct dollar object for number 10" in {
    val tenDollars = new Dollars(10)
    assert("$10" === tenDollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollars = new Dollars(10)
    val fiveDollars = new Dollars(5)
    assert(tenDollars > fiveDollars)
  }

  it should "correctly add two dollar amounts" in {
    val tenDollars = new Dollars(10)
    val fiveDollars = new Dollars(5)
    assertResult("$15") {
      (tenDollars + fiveDollars).toString
    }
  }

  it should "throw an exception if an illegal dollar amount is passed" in {
    assertThrows[ArithmeticException] {
      val infiniteDollars = new Dollars(1/0)
    }
  }

  it should "have every dollar greater than 0, illustrates use of assume to cancel test if precondition not met" in {
//      val dollarList = List(Dollars(1), Dollars(10), Dollars(100))
        val dollarList : List[Dollars] = List()
      assume(dollarList.nonEmpty, "The dollar list being returned by the API is empty")
      dollarList.foreach(dollar => assert(dollar.amount > 0))
  }

}
