package exceptions

class SiteParameterMissing : RuntimeException() {
    private var errorMessage: String = ""

    init {
        this.errorMessage = "No URL Provided"
    }
}
