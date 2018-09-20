package robots

import org.junit.jupiter.api.Test
import robots.entities.RobotsTxtChecker
import kotlin.test.assertFalse
import kotlin.test.assertTrue


//https://zoo.fusio2.com/robots.txt


class RobotsTxtVerifierTests {
    var invalidNotAllowed = "https://zoo.fusio2.com/"
    var validAllowed = "https://dublinzoo.ie/"

    @Test
    fun passesWhenEverythingIsAllowed() {
        val robotsTxt = RobotsTxtChecker()
        robotsTxt.parseURL(validAllowed)

        assertTrue { robotsTxt.canTheHomepageBeIndexed() }
    }

    @Test
    fun failsWhenEverythingIsBlocked() {
        val robotsTxt = RobotsTxtChecker()
        robotsTxt.parseURL(invalidNotAllowed)

        assertFalse { robotsTxt.canTheHomepageBeIndexed() }
    }
}