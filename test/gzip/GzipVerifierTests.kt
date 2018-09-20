package gzip

import info.hobocore.websiteChecklist.homepage.entities.Webpage
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GzipVerifierTests {
    var validUrl = "https://www.met.ie/css/met.css"
    var invalidUrl = "https://entertainment.ie"

    @Test
    fun passesOnAGzippedPage() {
        assertTrue { Webpage(validUrl).isGzipped() }
    }

    @Test
    fun failsOnANonGzippedPage() {
        assertFalse { Webpage(invalidUrl).isGzipped() }
    }
}