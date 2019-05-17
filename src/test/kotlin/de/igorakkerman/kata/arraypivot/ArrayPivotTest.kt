package de.igorakkerman.kata.arraypivot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ArrayPivotTest {

    class ArrayPivotSpy : ArrayPivot() {

        var shiftsCount = 0

        override fun set(a: IntArray, index: Int, value: Int) {
            shiftsCount ++
            super.set(a, index, value)
        }
    }

    private lateinit var arrayPivot: ArrayPivotSpy

    @BeforeEach
    internal fun setUp() {
        arrayPivot = ArrayPivotSpy()
    }

    @Test
    internal fun `empty 0`() {
        assertThat(arrayPivot.solution(intArrayOf(), 0))
                .isEmpty()
    }

    @Test
    internal fun `empty 1`() {
        assertThat(arrayPivot.solution(intArrayOf(), 0))
                .isEmpty()
    }

    @Test
    internal fun `empty someNumber`() {
        assertThat(arrayPivot.solution(intArrayOf(), 43))
                .isEmpty()
    }

    @Test
    internal fun `1 0`() {
        assertThat(arrayPivot.solution(intArrayOf(1), 0))
                .containsExactly(1)
    }

    @Test
    internal fun `1 1`() {
        assertThat(arrayPivot.solution(intArrayOf(1), 0))
                .containsExactly(1)
    }

    @Test
    internal fun `1 someNumber`() {
        assertThat(arrayPivot.solution(intArrayOf(1), 43))
                .containsExactly(1)
    }

    @Test
    internal fun `2 0`() {
        assertThat(arrayPivot.solution(intArrayOf(1, 2), 0))
                .containsExactly(1, 2)
    }

    @Test
    internal fun `2 1`() {
        assertThat(arrayPivot.solution(intArrayOf(1, 2), 1))
                .containsExactly(2, 1)
    }

    @Test
    internal fun `2 2`() {
        assertThat(arrayPivot.solution(intArrayOf(1, 2), 2))
                .containsExactly(1, 2)
    }

    @Test
    internal fun `3 1`() {
        assertThat(arrayPivot.solution(intArrayOf(1, 2, 3), 1))
                .containsExactly(3, 1, 2)
    }

    @Test
    internal fun `3 2`() {
        assertThat(arrayPivot.solution(intArrayOf(1, 2, 3), 2))
                .containsExactly(2, 3, 1)
    }

    @Test
    internal fun `3 3`() {
        assertThat(arrayPivot.solution(intArrayOf(1, 2, 3), 3))
                .containsExactly(1, 2, 3)
    }

    @Test
    internal fun `3 4`() {
        assertThat(arrayPivot.solution(intArrayOf(1, 2, 3), 4))
                .containsExactly(3, 1, 2)


        // TODO: try to get this down to 1 * (3-1) by shifting whole blocks
        assertThat(arrayPivot.shiftsCount)
                .isEqualTo(4 * 3)
    }

}