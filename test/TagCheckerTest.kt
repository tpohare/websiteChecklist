import homepage.entities.TagChecker
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class TagCheckerTest {
    lateinit var validPage:TagChecker
    lateinit var invalidPage:TagChecker

    @BeforeEach
    fun setup() {
        validPage = getSource("http://entertainment.ie/")
        invalidPage = getSource("http://www.coombe.ie")
    }

    @Test
    fun passesOnAValidOgTitle() {
        assertTrue { ogTitleIsValid(validPage) }
    }

    @Test
    fun failsOnAnInValidOgTitle() {
        assertFalse { ogTitleIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidOgImage() {
        assertTrue { ogImageIsValid(validPage) }
    }

    @Test
    fun failsOnInvalidOgImage() {
        assertFalse { ogImageIsValid(invalidPage) }
    }

    private fun ogImageIsValid(checker: TagChecker): Boolean {
        return checker.testOgImage()
    }

    private fun getSource(url:String) = TagChecker(url)

    private fun ogTitleIsValid(checker:TagChecker):Boolean{
        return checker.testOgTitle()
    }

}