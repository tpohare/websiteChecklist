package info.hobocore.websiteChecklist.tags.entities

import info.hobocore.websiteChecklist.homepage.entities.Webpage
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


class Tag(url: String) {
    private var page: Document = Jsoup.parse(Webpage(url).unGzipped())

    private fun exists(tag: String): Boolean {
        val instancesOfTag:Elements = page.select(tag)

        return instancesOfTag.size > 0
    }

    fun isOgTitleValid(): Boolean {
        return exists("meta[property=og:title]")
    }

    fun isOgImageValid(): Boolean {
        return exists("meta[property=og:image]")
    }

    fun isTitleTagValid(): Boolean {
        return exists("title")
    }

    fun isOgUrlValid(): Boolean {
        return exists("meta[property=og:url]")
    }

    fun isOgDescriptionValid(): Boolean {
        return exists("meta[property=og:description]")
    }

    fun isFacebookAppIdValid(): Boolean {
        return exists("meta[property=fb:app_id]")
    }

    fun isDescriptionValid(): Boolean {
        return exists("meta[name=description]")
    }

    fun isTwitterCardValid(): Boolean {
        return exists("meta[name=twitter:card]")
    }

    fun isTwitterTitleValid(): Boolean {
        return exists("meta[name=twitter:title]")
    }

    fun isTwitterDescriptionValid(): Boolean {
        return exists("meta[name=twitter:description]")
    }

    fun isTwitterImageValid(): Boolean {
        return exists("meta[name=twitter:image]")
    }

    fun isTwitterSiteValid(): Boolean {
        return exists("meta[name=twitter:site]")
    }
}
