package homepage.entities

import crawlercommons.robots.BaseRobotRules
import crawlercommons.robots.SimpleRobotRulesParser
import info.hobocore.websiteChecklist.homepage.entities.Webpage
import kotlinx.io.core.toByteArray

class RobotsTxtVerifier(rootUrl: String) {
    private var rules: BaseRobotRules

    init {
        val url = rootUrl + "robots.txt"
        val robotsTxtContent = Webpage(url).unzipped().toByteArray()
        val rulesParser = SimpleRobotRulesParser()

        this.rules = rulesParser.parseContent(url, robotsTxtContent, "application/text", "*")
    }

    fun canTheHomepageBeIndexed(): Boolean {
        return this.rules.isAllowed("/")
    }
}

