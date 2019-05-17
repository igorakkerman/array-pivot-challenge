package de.igorakkerman.kata.arraypivot

open class ArrayPivot {

    fun solution(a: IntArray, n: Int): IntArray {
        if (a.size <= 1)
            return a

        repeat(n) {
            val last = a[a.size - 1]
            (a.size - 1 downTo 1).forEach {
                set(a, it, a[it - 1])
            }
            set(a, 0, last)
        }

        return a
    }

    open fun set(a: IntArray, index: Int, value: Int) {
        a[index] = value
    }
}


