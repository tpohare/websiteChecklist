package analytics

import analytics.entities.AnalyticsChecker
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

    @Test
    fun passesOnAPageWithGoogleTagManager() {
        val hasTagManager = checkForTagManager("https://www.unicef.ie/")

        assertTrue { hasTagManager }
    }

    @Test
    fun failsOnAPageWithoutGoogleTagManager() {
        val hasTagManager = checkForTagManager("http://www.coombe.ie/")

        assertFalse { hasTagManager }
    }

    private fun checkForTagManager(url: String): Boolean {
        return AnalyticsChecker().checkForGoogleTagManager(url)
    }

    private fun checkForAnalytics(url:String): Boolean {
        return AnalyticsChecker().checkForAnalytics(url)
    }
}