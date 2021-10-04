package async

import com.h2.entities.Dollars
import org.scalatest.ParallelTestExecution
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.Future

class AsyncDollarSpec extends AsyncFlatSpec with Matchers with ParallelTestExecution {

  def addDollars(dollars: Dollars*) : Future[Dollars] = {
      Future {
          val totalAmount = dollars.map(dollar => dollar.amount).sum
          Dollars(totalAmount)
      }
  }

  behavior of "Async Dollars"
  it should "correctly add dollars in future" in {
    addDollars(Dollars(0), Dollars(3), Dollars(4)).map(dollar => dollar.amount should equal(7) )
  }

}
