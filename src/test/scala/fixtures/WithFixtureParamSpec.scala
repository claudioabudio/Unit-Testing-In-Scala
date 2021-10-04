package fixtures

import org.scalatest.Outcome
import org.scalatest.flatspec.FixtureAnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WithFixtureParamSpec extends FixtureAnyFlatSpec with Matchers {
  override protected def withFixture(test: OneArgTest): Outcome = ???

  override type FixtureParam = this.type
}
