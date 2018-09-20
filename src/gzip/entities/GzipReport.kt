package info.hobocore.websiteChecklist.gzip.entities

import gzip.entities.GzipChecker

data class GzipReport(val url: String) {
    private var gzipEnabled: Boolean

    init {
        val checker = GzipChecker(url)
        gzipEnabled = checker.check()
    }
}