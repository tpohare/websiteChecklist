package info.hobocore.websiteChecklist.homepage.entities

import kotlinx.io.core.toByteArray
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.util.zip.GZIPInputStream

class Webpage(url:String) {
    var inputStream:InputStream

    init {
        val obj = URL(url)
        val connection:HttpURLConnection = obj.openConnection() as HttpURLConnection
        connection.setRequestProperty("Accept-Encoding", "gzip")

        this.inputStream = connection.inputStream
    }

    fun unzipped(): String {
        return try {
            GZIPInputStream(this.inputStream).bufferedReader().use { it.readText() }
        } catch (e:IOException) {
            this.inputStream.bufferedReader().use { it.readText() }
        }
    }

    fun toByteArray(): ByteArray {
        val response = unzipped()
        return response.toByteArray()
    }
}