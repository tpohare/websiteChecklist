package info.hobocore.websiteChecklist.http

import exceptions.SiteParameterMissing
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText

open class Controller(var call: ApplicationCall) {
    suspend fun respond(body:String) {
        call.respondText(body, ContentType.Text.Html, HttpStatusCode.OK)
    }

    suspend fun respondWithJson(json:Any) {
        call.respond(json)
    }

    fun getQueryParameter(parameter: String): String {
        return call.request.queryParameters[parameter] ?: throw SiteParameterMissing()
    }
}