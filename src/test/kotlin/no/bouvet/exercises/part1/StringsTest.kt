package no.bouvet.exercises.part1

import org.junit.Assert.assertEquals
import org.junit.Test

class StringsTest {

    @Test
    fun testStuff() {
        val strings = Strings()
        assertEquals(strings.stringFormat("Answer", 42), "Answer=42")

        assertEquals(strings.splitString("Kjernlie, Simen, 28"), "SK: 28")

        assertEquals(strings.isPalindrome("racecar"), true)
        assertEquals(strings.isPalindrome("abrakadabra"), false)

        assertEquals(strings.jsonFormat(listOf(1, 2, 3)), "[1, 2, 3]")
        assertEquals(strings.jsonFormat(emptyList()), "[]")


        val strippedJson = strings.movieToJson("Avengers: Endgame", 2019, 181).filter { !it.isWhitespace() }
        assertEquals(strippedJson, """{"title":"Avengers:Endgame","year":2019,"runtime":181,"rating":"PG-12","country":"USA"}""")

        assertEquals(strings.acronym("application programming interface"), "API")
        assertEquals(strings.acronym("gnu's not unix"), "GNU")
    }
}