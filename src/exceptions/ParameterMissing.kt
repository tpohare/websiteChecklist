package exceptions

data class ParameterMissing(
        val parameter: String,
        val friendlyMessage: String = "You are missing a required parameter"
) : Throwable()
