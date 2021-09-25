package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {
      behavior of "an Email"
      it should "return an Email object for a valid string email address" in {
        val email = new Email("claudio" , "gmail.com")
        assert("claudio" === email.localPart)
        assert("gmail.com" === email.domain)
      }
}
