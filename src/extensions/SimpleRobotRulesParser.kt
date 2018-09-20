package info.hobocore.websiteChecklist.extensions

import crawlercommons.robots.BaseRobotRules
import crawlercommons.robots.SimpleRobotRulesParser

fun SimpleRobotRulesParser.parseTxt(txt: String, url:String): BaseRobotRules {
    return parseContent(url, txt.toByteArray(),"application/text", "*")
}