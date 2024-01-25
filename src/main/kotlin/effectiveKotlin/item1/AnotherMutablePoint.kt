package effectiveKotlin.item1

import kotlin.concurrent.thread
import kotlin.properties.Delegates

val list1: MutableList<Int> = mutableListOf(1,2,3)
var list2: List<Int> = listOf(1,2,3)

var names by Delegates.observable(listOf<String>()) { _, old, new ->
    println("Names changed from $old to $new")
}

var announcements = listOf<Announcements>()
    private set(value) {
        println("Announcement changed from ${field.toString()} to ${value.toString()}")
        field = value
    }

data class Announcements(val message: String)

fun main() {
    // 두 가지 모두 변경 가능, but 방벙이 다름
    list1.add(4)
    list2 = list2 + 4

    list1 += 5 // list1.plusAssign(5) 와 동일
    list2 += 5 // list2 = list2.plus(5) 와 동일

    for (i in 1..1000) {
        thread {
            list2 += i
        }
    }
    Thread.sleep(1000)
    println(list2.size)

    names += "ryu"
    // Names changed from [] to [ryu]
    names += "seungmin"
    // Names changed from [ryu] to [ryu, seungmin]

    announcements += Announcements("Hello")
//    Announcement changed from [] to [Announcements(message=Hello)]
    announcements += Announcements("World")
//    Announcement changed from [Announcements(message=Hello)] to [Announcements(message=Hello), Announcements(message=World)]

}