package dev.pfilaretov42.kotlin.nullsafety

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class NullSafetyTest {
    @Test
    fun `test null safety`() {
        // mockito
        val interfaceMock = mock(MyInterface::class.java)
        // OK
        whenever(interfaceMock.test(any())).thenReturn(0)

        val classMock = mock(MyClass::class.java)
        // NPE:
        whenever(classMock.test(any())).thenReturn(0)

        val abstractClassMock = mock(MyAbstractClass::class.java)
        // OK
        whenever(abstractClassMock.abstractTest(any())).thenReturn(0)
        // NPE:
        whenever(abstractClassMock.test(any())).thenReturn(0)

        // mockk
        val interfaceMockk = mockk<MyClass>()
        // OK
        every { interfaceMockk.test(any()) } returns 2

        val classMockk = mockk<MyClass>()
        // OK
        every { classMockk.test(any()) } returns 2
    }
}