package info.hobocore.websiteChecklist.tags.entities

data class OgTagReport(val url:String) {
    private var ogTitleValid: Boolean = false
    private var ogImageValid: Boolean = false
    private var titleTagValid: Boolean = false
    private var ogUrlValid: Boolean = false
    private var ogDescriptionValid: Boolean = false
    private var facebookAppIdValid: Boolean = false
    private var descriptionValid: Boolean = false
    private var twitterCardValid: Boolean = false
    private var twitterTitleValid: Boolean = false
    private var twitterDescriptionValid: Boolean = false
    private var twitterImageValid: Boolean = false
    private var twitterSiteValid: Boolean = false

    init {
        val checker = Tag(url)
        this.ogTitleValid = checker.isOgTitleValid()
        this.ogImageValid = checker.isOgImageValid()
        this.titleTagValid = checker.isTitleTagValid()
        this.ogUrlValid = checker.isOgUrlValid()
        this.ogDescriptionValid = checker.isOgDescriptionValid()
        this.facebookAppIdValid = checker.isFacebookAppIdValid()
        this.descriptionValid = checker.isDescriptionValid()
        this.twitterCardValid = checker.isTwitterCardValid()
        this.twitterTitleValid = checker.isTwitterTitleValid()
        this.twitterDescriptionValid = checker.isTwitterDescriptionValid()
        this.twitterImageValid = checker.isTwitterImageValid()
        this.twitterSiteValid = checker.isTwitterSiteValid()
    }
}