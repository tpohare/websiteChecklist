import homepage.entities.AnalyticsChecker
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnalyticsCheckerTest {
    @Test
    fun passesOnAPageWithAnalytics() {
        val hasAnalytics = checkForAnalytics("https://www.dublinzoo.ie/")

        assertTrue { hasAnalytics }
    }

    @Test
    fun failsOnAPageWithoutAnalytics() {
        val hasAnalytics = checkForAnalytics("http://www.coombe.ie/")

        assertFalse { hasAnalytics }
    }

    private fun checkForAnalytics(url:String): Boolean {
        return AnalyticsChecker().checkForAnalytics(url)
    }
}