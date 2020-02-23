package no.bouvet.exercises.part2

import no.bouvet.data.Task
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.reflect.KProperty1

class ClassesTest {

    val classes = Classes()

    @Test
    fun testStuff() {
        val task = classes.taskInstanse()
        assertEquals(task.description, "Buy milk")
        assertEquals(task.priority, 1)
        assertEquals(task.id, 100)

        val completedTask = classes.completedTask()
        // assertEquals(completedTask.completed, true)

        assertEquals(classes.comparable(task, completedTask), 0)
        val t1 = Task(1, "", 10)
        val t2 = Task(2, "", 11)

        assertEquals(classes.comparable(t1, t2), -1)
        assertEquals(classes.comparable(t1, t1), 0)
        assertEquals(classes.comparable(t2, t1), 1)

        val task2 = classes.taskInstanse()
        assertEquals(classes.equality(task, task2), true)
        assertEquals(classes.dataClassEquality(task, task2), true)
        assertEquals(classes.copyAndComplete(task), task)
    }

    @Test
    fun testEquality() {
        val t1 = Task(1, "Foo", 10)
        val t2 = Task(1, "Foo", 10)
        val t3 = Task(2, "Foo", 10)
        val t4 = Task(1, "Bar", 10)
        val t5 = Task(1, "Foo", 11)
        assertEquals(classes.equality(t1, t1), true)
        assertEquals(classes.equality(t1, t2), true)
        assertEquals(classes.equality(t1, t3), false)
        assertEquals(classes.equality(t1, t4), false)
        assertEquals(classes.equality(t1, t5), false)
    }

    @Test
    fun testDataClass() {
        assertTrue(Task::class.isData)
        val t1 = Task(1, "Foo", 10)
        val t2 = Task(1, "Foo", 10)
        val t3 = Task(2, "Foo", 10)
        val t4 = Task(1, "Bar", 10)
        val t5 = Task(1, "Foo", 11)
        assertEquals(classes.dataClassEquality(t1, t1), true)
        assertEquals(classes.dataClassEquality(t1, t2), true)
        assertEquals(classes.dataClassEquality(t1, t3), false)
        assertEquals(classes.dataClassEquality(t1, t4), false)
        assertEquals(classes.dataClassEquality(t1, t5), false)
    }

/*    @Test
    fun testCopy() {
        assertTrue(Task::class.isData)
        val task = Task(1, "Foo", 10)
        val copy = classes.copyAndComplete(task)
        classes.completed?.invoke(copy) shouldBe true }
    }*/
}