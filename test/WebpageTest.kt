import info.hobocore.websiteChecklist.homepage.entities.Webpage
import org.junit.jupiter.api.Test
import java.io.InputStream
import kotlin.test.assertEquals

class WebpageTest {

    @Test
    fun queryingForAURLReturnsAnInputStream() {
        val response:InputStream = Webpage("http://example.com").inputStream
        val responseSize:Int = response.readBytes().size

        assertEquals(606, responseSize)
    }
}