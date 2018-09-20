package gzip

import gzip.entities.GzipChecker
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GzipVerifierTests {
    @Test
    fun passesOnAGzippedPage() {
        val url = "https://www.met.ie/css/met.css"
        val isValid: Boolean = GzipChecker(url).check()

        assertTrue { isValid }
    }

    @Test
    fun failsOnANonGzippedPage() {
        val url = "https://entertainment.ie"
        val isValid: Boolean = GzipChecker(url).check()

        assertFalse { isValid }
    }
}