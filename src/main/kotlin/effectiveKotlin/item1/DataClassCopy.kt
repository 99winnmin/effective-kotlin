package effectiveKotlin.item1

import java.util.*

fun main() {
    setAndMap()
}

fun setAndMap() {
    val names: SortedSet<FullName> = TreeSet()
    val person = FullName("ryu", "seungmin")
    names.add(person)
    names.add(FullName("aaa", "aaaaa"))
    names.add(FullName("bbb", "bbbbb"))

    println(names)
    println(person in names) // true

    person.name = "ryu2"
    println(names)
    println(person in names) // false

    var user = IMUser("ryu", "seungmin")
    user = user.withSurname("seungmin2")
    println(user)

    var user2 = DCUser("ryu", "seungmin")
    user2 = user2.copy(surname = "seungmin2")
    println(user2)
}

class FullName(var name: String, var surname: String) {
}

class IMUser(val name: String, val surname: String) {
    // 프로퍼티 하나하나 다 만드는 것은 굉장히 귀찮은 일
    fun withSurname(surname: String) = IMUser(name, surname)
}

// data class 의 copy 를 활용하여 불변한 객체를 만들 수 있음
data class DCUser(val name: String, val surname: String)
