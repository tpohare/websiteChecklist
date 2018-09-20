package info.hobocore.websiteChecklist.homepage.entities

import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.GZIPInputStream

class Webpage(url:String) {
    var inputStream:InputStream

    init {
        val obj = URL(url)
        val connection:HttpURLConnection = obj.openConnection() as HttpURLConnection
        connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

        this.inputStream = connection.inputStream
    }

    fun unGzipped(): String {
        return try {
            // GZIPInputStream will throw if it's not given a gzipped Input Stream as a param.
            GZIPInputStream(this.inputStream).bufferedReader().use { it.readText() }
        } catch (e:IOException) {
            this.inputStream.bufferedReader().use { it.readText() }
        }
    }
}