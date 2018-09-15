package homepage.entities

import info.hobocore.websiteChecklist.homepage.entities.Webpage
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


class TagChecker(url:String) {
    private var page: Document = Jsoup.parse(Webpage(url).unzipped())

    fun testOgTitle(): Boolean {
        return tagExists("meta[property=og:title]")
    }

    fun testOgImage(): Boolean {
        return tagExists("meta[property=og:image]")
    }

    private fun tagExists(tag:String):Boolean {
        val instancesOfTag:Elements = page.select(tag)

        return instancesOfTag.size > 0
    }
}
