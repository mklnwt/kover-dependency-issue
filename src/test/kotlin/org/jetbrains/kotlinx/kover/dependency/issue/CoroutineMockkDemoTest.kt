package org.jetbrains.kotlinx.kover.dependency.issue

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.justRun
import io.mockk.mockk
import org.junit.jupiter.api.Test

class CoroutineMockkDemoTest {
    private val demo = mockk<Demo>()

    @Test
    fun `Should foo`() {
        justRun { demo.foo() }
    }

    @Test
    fun `Should bar`() {
        every { demo.bar() } returns Unit
    }

    @Test
    fun `Should baz`() {
        every { demo.baz() } just Runs
    }

    @Test
    fun `Should qux`() {
        every { demo.qux() } returns "Baz mock"
    }
}

class Demo {
    fun foo() {
        println("foo")
    }

    fun bar(): Unit = println("bar")

    fun baz() {
        println("baz")
    }

    fun qux(): String {
        println("qux")
        return "baz"
    }
}
