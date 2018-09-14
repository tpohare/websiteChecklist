import homepage.entities.RobotsTxtVerifier
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


//https://zoo.fusio2.com/robots.txt


class RobotsTxtVerifierTests {
    var invalidNotAllowed = "https://zoo.fusio2.com/"
    var validAllowed = "https://dublinzoo.ie/"

    @Test
    fun passesWhenEverythingIsAllowed() {
        val robotsTxt = RobotsTxtVerifier(validAllowed)

        assertTrue { robotsTxt.canTheHomepageBeIndexed() }
    }

    @Test
    fun failsWhenEverythingIsBlocked() {
        val robotsTxt = RobotsTxtVerifier(invalidNotAllowed)

        assertFalse { robotsTxt.canTheHomepageBeIndexed() }
    }


}