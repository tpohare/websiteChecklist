package info.hobocore.websiteChecklist.homepage.entities

import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class Webpage {
    fun getStream(url:String): InputStream {
        val obj = URL(url)

        with(obj.openConnection() as HttpURLConnection) {
            return inputStream
        }
    }
}