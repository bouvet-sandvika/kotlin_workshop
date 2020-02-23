package no.bouvet.exercises.part2

import no.bouvet.data.AppInfo
import no.bouvet.data.Category
import no.bouvet.data.ContentRating
import no.bouvet.data.Genre
import no.bouvet.service.playstore.parseCsv
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CollectionsTest {

    val appInfoList: List<AppInfo> = parseCsv("src/main/resources/googleplaystore.csv")

    @Test
    fun testRatedApps() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.ratedApps(), 9366)
    }

    @Test
    fun testAverageRating() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.averageRating(), (4.18..4.20))
    }

    @Test
    fun testCategory() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.averageRating(Category.ART_AND_DESIGN),  (4.34..4.36))
    }

    @Test
    fun testMostExpensive() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.mostExpensiveApp().name, "I'm Rich - Trump Edition")
    }

    @Test
    fun testTotalReviews() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.totalReviews(), 4817617393L)
    }

    @Test
    fun testByRating() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        val categoriesByRating = appStats.categoriesOrderedByRating()
        assertEquals(categoriesByRating.first(), Category.EVENTS)
        assertEquals(categoriesByRating.last(), Category.DATING)
    }

    @Test
    fun testSorting() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        val categoriesByNumberOfApps = appStats.categoriesOrderedByNumberOfApps()
        assertEquals(categoriesByNumberOfApps.first(), Pair(Category.FAMILY, 1972))
        assertEquals(categoriesByNumberOfApps.last(), Pair(Category.BEAUTY, 53))
    }

    @Test
    fun testGenre() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.averageRatingForGenre(Genre.TRIVIA), (4.029..4.049))
    }

    @Test
    fun testHighestRated() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.highestRatedGenre(), Genre.EVENTS)
    }

    @Test
    fun testCategoryStats() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        val categoryStat = appStats.categoryStats(Category.EVENTS)
        assertEquals(categoryStat.name, Category.EVENTS.name)
                assertEquals(categoryStat.averagePrice, (1.708..1.728))
                assertEquals(categoryStat.size, 64)
                assertEquals(categoryStat.averageRating, (4.425..4.445))
    }

    @Test
    fun testContentRating() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        val groups = appStats.groupByContentRating()
        assertEquals(groups.size, 6)
        assertEquals(groups[ContentRating.EVERYONE]?.size, 8714)
        val appInfo = appInfoList.find { it.contentRating == ContentRating.TEEN }
        assertTrue(groups[ContentRating.TEEN]!!.contains(appInfo))
    }

    @Test
    fun testContentRatingAverage() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        val contentRatingMap = appStats.averageRatingByContentRating()
        assertEquals(contentRatingMap.size, 6)
        assertEquals(contentRatingMap[ContentRating.ADULTS_18], (4.29..4.31))
        assertEquals(contentRatingMap[ContentRating.UNRATED], (4.09..4.11))
    }

    @Test
    fun testTopRated() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        val topRated = appStats.topRated(10)
        assertEquals(topRated[0], Triple("Ríos de Fe", 5.0, 141))
        assertEquals(topRated[4], Triple("Master E.K", 5.0, 90))
        assertEquals(topRated[9], Triple("Ek Vote", 5.0, 43))
    }

    @Test
    fun testFindApps() {
        val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
        assertEquals(appStats.findApps(minRating = 4.0, maxPrice = 10.0).first().name,  "Facebook")
        assertEquals(appStats.findApps(minRating = 4.5, maxPrice = 10.0, category = Category.BEAUTY).first().name,  "ipsy: Makeup, Beauty, and Tips")
        assertEquals(appStats.findApps(minRating = 3.5, maxPrice = 1.0, genre = Genre.BRAIN_GAMES).first().name,  "Where's My Water? Free")
    }
}