package info.hobocore.websiteChecklist

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.sessions.*
import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.client.*
import io.ktor.client.engine.jetty.*
import io.ktor.http.content.resources
import io.ktor.http.content.static
import info.hobocore.websiteChecklist.exceptions.AuthenticationFailed
import info.hobocore.websiteChecklist.exceptions.AuthorizationFailed
import info.hobocore.websiteChecklist.homepage.Homepage
import info.hobocore.websiteChecklist.persistence.UserSession
import io.ktor.server.netty.DevelopmentEngine

fun main(args: Array<String>): Unit = DevelopmentEngine.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    //region Boot
    install(Locations) {
    }

    install(Sessions) {
        cookie<UserSession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024) // condition
        }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    install(ConditionalHeaders)

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }

    val client = HttpClient(Jetty) {
    }
    //endregion

    routing {
        get("/") {
            Homepage(call).index()
        }

        //region static files
        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }
        //endregion

        //region Errors
        install(StatusPages) {
            exception<AuthenticationFailed> {  cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
            exception<AuthorizationFailed> {  cause ->
                call.respond(HttpStatusCode.Forbidden)
            }

        }
        //endregion
    }
}
