package robots.entities

import crawlercommons.robots.BaseRobotRules
import crawlercommons.robots.SimpleRobotRulesParser
import info.hobocore.websiteChecklist.extensions.parseTxt
import info.hobocore.websiteChecklist.homepage.entities.Webpage

class RobotsTxtRules() {
    private lateinit var rules: BaseRobotRules

    fun parseURL(rootUrl: String) {
        val url = rootUrl + "robots.txt"

        val robotsTxt:String = Webpage(url).unGzipped()
        val rulesParser = SimpleRobotRulesParser()

        this.rules = rulesParser.parseTxt(robotsTxt, url)
    }

    fun canTheHomepageBeIndexed(): Boolean {
        return this.rules.isAllowed("/")
    }
}

