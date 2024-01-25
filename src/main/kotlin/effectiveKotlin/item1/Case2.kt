package effectiveKotlin.item1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

suspend fun main() {
    fun1()
    fun2()
}

fun fun1() {
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(100)
            num++
        }
    }

    Thread.sleep(1000)
    println(num) // 1000이 아닌 다른 값이 출력됨, 실행할 때마다 다른 값 출력
}

suspend fun fun2() {
    var num = 0
    coroutineScope {
        for (i in 1..1000) {
            launch {
                delay(100)
                num++
            }
        }
    }

    Thread.sleep(1000)
    println(num) // 1000이 아닌 다른 값이 출력됨, 실행할 때마다 다른 값 출력
}

fun fun3() {
    var lock = Any()
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(100)
            synchronized(lock) {
                num++
            }
        }
    }

    Thread.sleep(1000)
    println(num) // 1000
}