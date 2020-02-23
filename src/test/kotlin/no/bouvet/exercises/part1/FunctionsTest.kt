package no.bouvet.exercises.part1

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionsTest {

    @Test
    fun testStuff() {
        val functions = Functions()
        assertEquals(functions.helloWorld(), "Hello World!")

        assertEquals(functions.assignment(), 25)

        assertEquals(functions.varAndVal("Romeo", "Juliet"), "Romeo and Juliet")

        assertEquals(functions.square(5), 25)
        assertEquals(functions.square(2), 4)

        assertEquals(functions.max(5, 7), 7)
        assertEquals(functions.max(7, 5), 7)

        assertEquals(functions.maxOf3(7, 5, 3), 7)
        assertEquals(functions.maxOf3(3, 5, 7), 7)
    }
}