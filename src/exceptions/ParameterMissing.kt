package exceptions

import com.google.gson.JsonObject

data class ParameterMissing(val parameter: String) : Throwable() {

    fun message(): JsonObject {
        var message = JsonObject()
        message.addProperty("message", "You are missing a required parameter")
        message.addProperty("parameter", parameter)

        return message
    }
}
