package no.bouvet.exercises.part2

import org.junit.Assert.assertEquals
import org.junit.Test

class LambdasTest {

    @Test
    fun testStuff() {
        val lambdas = Lambdas()
        assertEquals(lambdas.filterUpperCase("AbCdEfG"), "ACEG")
        assertEquals(lambdas.letterCount("ABRAKADABRA", 'A'), 5)

        assertEquals(lambdas.oneOrZero(10) { true }, '1')
        assertEquals(lambdas.oneOrZero(10) { false }, '0')

        assertEquals(lambdas.intOperation(4, 2, Int::plus), 6)
        assertEquals(lambdas.intOperation(10, 5, Int::div), 2)

        assertEquals(lambdas.surroundString("<", ">")("jalla"), "<jalla>")
    }
}