package no.bouvet.exercises.part1

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.Instant

class TypesTest {

    @Test
    fun testStuff() {
        val types = Types()
        assertEquals(types.nullable("Simen", null, "Kjernlie", "footballer"), """
            FIRSTNAME: Simen
            MIDDLENAME: NA
            LASTNAME: Kjernlie
            OCCUPATION: Footballer
        """.trimIndent())

        //assertEquals(types.findPetAndCategoryName())

        assertEquals(types.mysteryInput("Arsenal"), 'A')
        assertEquals(types.mysteryInput(100), 50)
        assertEquals(types.mysteryInput(3), 1)
        assertEquals(types.mysteryInput(3.14), 0)
        assertEquals(types.mysteryInput(-1.0), -1)
        assertEquals(types.mysteryInput(Instant.now()), null)
    }
}