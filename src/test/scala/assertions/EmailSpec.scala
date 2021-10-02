package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {
      behavior of "an Email"
      it should "return an Email object for a valid string email address" in {
        val email = new Email("claudio" , "gmail.com")
        assert("claudio" === email.localPart, "expected localPart to be claudio ")
        assert("gmail.com" === email.domain)
      }

      it should "intercept the correct message when no '@' symbol is provided" in {
          val exceptionThrown = intercept[IllegalArgumentException] {
              Email("claudio_gmail.com")
          }
          assert(exceptionThrown.isInstanceOf[IllegalArgumentException])
          assert(exceptionThrown.getMessage === "invalid email: does not contain '@' symbol")
      }

      it should "fail unconditionally !" in {
        fail()
      }

      ignore should "be ignored !" in {
          fail()
      }

      it should "return the localPart corresponding to the original string" in {
        val email = Email("clau1@gmail.com")
        assertResult("clau", "expected local part to be clau") {
            email.localPart
        }
      }

      it should "throw Illegal argument exception if the email is not correctly formatted" in {
        withClue ("Should have thrown a IllegalArgumentException instead !") {
          assertThrows[ArrayIndexOutOfBoundsException] {
            val email = Email(".com")
          }
        }
      }
}
