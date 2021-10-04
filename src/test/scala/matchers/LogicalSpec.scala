package matchers

import com.h2.services.Currency

class LogicalSpec extends UnitSpec {
    behavior of "Currencies as logical and/or"
    it should "Successfully match logical expression with 'and' condition for a currency " in {
        val nzUsd : Currency = "10 NZD"
        nzUsd.amount should (be > (0.0) and be < (12.0))
        nzUsd.costInDollars.amount should (be > 0 and be < 12 )
    }
}
