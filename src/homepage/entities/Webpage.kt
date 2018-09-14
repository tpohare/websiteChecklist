package info.hobocore.websiteChecklist.homepage.entities

import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class Webpage(url:String) {
    var inputStream:InputStream

    init {
        val obj = URL(url)

        val connection:HttpURLConnection = obj.openConnection() as HttpURLConnection
        connection.setRequestProperty("Accept-Encoding", "gzip")

        this.inputStream = connection.inputStream
    }

//    fun getStream(): InputStream {
//        return inputStream
//    }
}