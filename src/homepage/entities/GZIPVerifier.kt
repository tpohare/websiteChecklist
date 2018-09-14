package homepage.entities

import java.io.IOException
import java.io.InputStream
import java.util.zip.GZIPInputStream

class GZIPVerifier {
    fun runTest(inputStream: InputStream): Boolean {
        // GZIPInputStream will throw if it's not given a gzipped Input Stream as a param.
        return try {
            GZIPInputStream(inputStream)

            true
        } catch (e:IOException) {
            false
        }
    }
}
