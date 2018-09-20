package exceptions

data class ParameterMissing(
        val parameterMissing: String,
        val errorMessage: String = "A required parameter is missing")
    : Throwable()