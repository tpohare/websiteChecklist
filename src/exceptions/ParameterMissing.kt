package exceptions

data class ParameterMissing(val parameterMissing: String) : Throwable() {
    private var errorMessage: String = ""

    init {
        this.errorMessage = "No URL Provided"
    }
}
