package tags

import info.hobocore.websiteChecklist.tags.entities.TagBag
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TagCheckerTest {
    private lateinit var validPage: TagBag
    private lateinit var invalidPage: TagBag

    @BeforeEach
    fun setup() {
        validPage = getSource("https://www.theverge.com/")
        invalidPage = getSource("https://notifications.google.com/_/scs/social-static/_/js/k=boq.NotificationsOgbUi.en.EeBysumYvsY.O/ck=boq.NotificationsOgbUi.z8o8n66ljwng.L.W.O/am=QCAYhhYgBAAP/rt=j/d=0/excm=home,_b,_tp/ed=1/rs=AGLTcCPTGjVKc7GrUB3odcBAL-impZPT4A/m=sy5z,_latency,sy3r,FCpbqb,WhJNk")
    }

    @Test
    fun passesOnAValidOgUrl() {
        assertTrue { ogUrlIsValid(validPage)}
    }

    @Test
    fun failsOnAnInvalidOgUrl() {
        assertFalse { ogUrlIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidOgTitle() {
        assertTrue { ogTitleIsValid(validPage) }
    }

    @Test
    fun failsOnAnInValidOgTitle() {
        assertFalse { ogTitleIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidOgDescription() {
        assertTrue { ogDescriptionIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidOgDescription(){
        assertFalse { ogDescriptionIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidOgImage() {
        assertTrue { ogImageIsValid(validPage) }
    }

    @Test
    fun failsOnInvalidOgImage() {
        assertFalse { ogImageIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidTitleTag() {
        assertTrue { titleTagIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidTitleTag() {
        assertFalse { titleTagIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidFacebookAppId() {
        assertTrue { fbIdIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidFacebookAppId() {
        assertFalse { fbIdIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidDescriptionTag() {
        assertTrue { descriptionIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidDescriptionTag() {
        assertFalse { descriptionIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidTwitterCard() {
        assertTrue { twitterCardIsValid(validPage) }
    }

    @Test
    fun failsOnAValidTwitterCard() {
        assertFalse { twitterCardIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidTwitterTitle() {
        assertTrue { twitterTitleIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidTwitterTitle() {
        assertFalse { twitterTitleIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidTwitterImage() {
        assertTrue { twitterImageIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidTwitterImage() {
        assertFalse { twitterImageIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidTwitterSite(){
        assertTrue { twitterSiteIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidTwitterSite(){
        assertFalse { twitterSiteIsValid(invalidPage) }
    }

    @Test
    fun passesOnAValidTwitterDescription() {
        assertTrue { twitterDescriptionIsValid(validPage) }
    }

    @Test
    fun failsOnAnInvalidTwitterDescription() {
        assertFalse { twitterDescriptionIsValid(invalidPage) }
    }

    private fun twitterSiteIsValid(checker: TagBag): Boolean {
        return checker.isTwitterSiteValid()
    }

    private fun twitterImageIsValid(checker: TagBag): Boolean {
        return checker.isTwitterImageValid()
    }

    private fun twitterTitleIsValid(checker: TagBag): Boolean {
        return checker.isTwitterTitleValid()
    }

    private fun twitterCardIsValid(checker: TagBag): Boolean {
        return checker.isTwitterCardValid()
    }

    private fun twitterDescriptionIsValid(checker: TagBag): Boolean {
        return checker.isTwitterDescriptionValid()
    }

    private fun descriptionIsValid(checker: TagBag): Boolean {
        return checker.isDescriptionValid()
    }

    private fun fbIdIsValid(checker: TagBag): Boolean {
        return checker.isFacebookAppIdValid()
    }

    private fun ogDescriptionIsValid(checker: TagBag): Boolean {
        return checker.isOgDescriptionValid()
    }

    private fun ogUrlIsValid(checker: TagBag): Boolean {
        return checker.isOgUrlValid()
    }

    private fun titleTagIsValid(checker: TagBag): Boolean {
        return checker.isTitleTagValid()
    }

    private fun ogImageIsValid(checker: TagBag): Boolean {
        return checker.isOgImageValid()
    }

    private fun getSource(url: String): TagBag = TagBag(url)

    private fun ogTitleIsValid(checker: TagBag): Boolean {
        return checker.isOgTitleValid()
    }

}