package info.hobocore.websiteChecklist.tags.entities

import info.hobocore.websiteChecklist.homepage.entities.Webpage
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


class TagChecker(url:String) {
    private var page: Document = Jsoup.parse(Webpage(url).unGzipped())

    private fun tagExists(tag:String):Boolean {
        val instancesOfTag:Elements = page.select(tag)

        return instancesOfTag.size > 0
    }

    fun isOgTitleValid(): Boolean {
        return tagExists("meta[property=og:title]")
    }

    fun isOgImageValid(): Boolean {
        return tagExists("meta[property=og:image]")
    }

    fun isTitleTagValid(): Boolean {
        return tagExists("title")
    }

    fun isOgUrlValid(): Boolean {
        return tagExists("meta[property=og:url]")
    }

    fun isOgDescriptionValid(): Boolean {
        return tagExists("meta[property=og:description]")
    }

    fun isFacebookAppIdValid(): Boolean {
        return tagExists("meta[property=fb:app_id]")
    }

    fun isDescriptionValid(): Boolean {
        return tagExists("meta[name=description]")
    }

    fun isTwitterCardValid(): Boolean {
        return tagExists("meta[name=twitter:card]")
    }

    fun isTwitterTitleValid(): Boolean {
        return tagExists("meta[name=twitter:title]")
    }

    fun isTwitterDescriptionValid(): Boolean {
        return tagExists("meta[name=twitter:description]")
    }

    fun isTwitterImageValid(): Boolean {
        return tagExists("meta[name=twitter:image]")
    }

    fun isTwitterSiteValid(): Boolean {
        return tagExists("meta[name=twitter:site]")
    }
}
