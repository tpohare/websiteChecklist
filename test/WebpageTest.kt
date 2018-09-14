import info.hobocore.websiteChecklist.homepage.entities.Webpage
import org.junit.jupiter.api.Test
import java.io.InputStream
import kotlin.test.assertEquals

class WebpageTest {

    @Test
    fun queryingForAURLReturnsAnInputStream() {
        val response:InputStream = Webpage().getStream("http://example.com")
        val responseSize:Int = response.readBytes().size

        assertEquals(1270, responseSize)
    }
}