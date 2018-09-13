package info.hobocore.websiteChecklist.homepage

import info.hobocore.websiteChecklist.http.Controller
import io.ktor.application.ApplicationCall

class Homepage(call: ApplicationCall) : Controller(call) {
    suspend fun index() {
        respond("<html>" +
                "<head>" +
                "<title>KTOR</title>" +
                "</head>" +
                "<body>" +
                "<img src='static/ktor_logo.svg' />" +
                "<p>Now in the structure I wanted, and with a package name that makes more sense</p>" +
                "</body>" +
                "</html>")
    }
}