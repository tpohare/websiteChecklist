package info.hobocore.websiteChecklist.gzip.entities

import info.hobocore.websiteChecklist.homepage.entities.Webpage

data class GzipReport(val url: String) {
    private var gzipEnabled: Boolean

    init {
        val webpage = Webpage(url)
        gzipEnabled = webpage.isGzipped()
    }
}