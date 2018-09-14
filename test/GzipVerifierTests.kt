import homepage.entities.GZIPVerifier
import info.hobocore.websiteChecklist.homepage.entities.Webpage
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GzipVerifierTests {
    @Test
    fun passesOnAGzippedPage() {
        val webpage = Webpage("https://www.met.ie/css/met.css")
        val isValid: Boolean = GZIPVerifier().runTest(webpage.inputStream)

        assertTrue { isValid }
    }

    @Test
    fun failsOnANonGzippedPage() {
        val webpage = Webpage("https://entertainment.ie")
        val isValid: Boolean = GZIPVerifier().runTest(webpage.inputStream)

        assertFalse { isValid }
    }
}