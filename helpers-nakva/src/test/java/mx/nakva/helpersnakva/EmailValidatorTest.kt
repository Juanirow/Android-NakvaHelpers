package mx.nakva.helpersnakva

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Juancho on 04/11/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EmailValidatorTest {

    @Test
    internal fun shouldReturnFalseEmailEmpty() {
        val email = ""
        assert(!EmailValidator.isValid(email))
    }

    @Test
    fun shouldReturnFalseEmailInvalidForText() {
        val email = "nailah"
        assert(!EmailValidator.isValid(email))
    }

    @Test
    fun shouldReturnFalseEmailInvalidWithATSymbol() {
        val email = "nailah@nakva"
        assert(!EmailValidator.isValid(email))
    }

    @Test
    fun shouldReturnFalseEmailWithProviderWithoutDomain() {
        val email = "nailah@nakva."
        assert(!EmailValidator.isValid(email))
    }

    @Test
    fun shouldReturnTrueEmailValid() {
        val email = "nailah@nakva.com"
        assert(EmailValidator.isValid(email))
    }

    @Test
    fun shouldReturnTrueEmailMultipleDomains() {
        val email = "nailah@nakva.com.mx"
        assert(EmailValidator.isValid(email))
    }
}