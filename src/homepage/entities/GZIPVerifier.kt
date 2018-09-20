package homepage.entities

import info.hobocore.websiteChecklist.homepage.entities.Webpage
import java.io.IOException
import java.util.zip.GZIPInputStream

class GZIPVerifier {
    fun runTest(webpage:Webpage): Boolean {
        // GZIPInputStream will throw if it's not given a gzipped Input Stream as a param.
        return try {
            GZIPInputStream(webpage.inputStream)

            true
        } catch (e:IOException) {
            false
        }
    }
}
