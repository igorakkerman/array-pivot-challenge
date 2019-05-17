package de.igorakkerman.kata.arraypivot

open class ArrayPivot {

    fun solution(a: IntArray, n: Int): IntArray {
        if (a.size <= 1)
            return a

        @Suppress("NAME_SHADOWING")
        val n = n % a.size

        val last = IntArray(n)

        (0 until n).forEach {
            set(last, it, a[a.size - n + it])
        }

        (1..a.size - n).forEach {
            set(a, a.size - it, a[a.size - n - it])
        }

        (0 until n).forEach {
            set(a, it, last[it])
        }

        return a
    }

    open fun set(a: IntArray, index: Int, value: Int) {
        a[index] = value
    }
}


