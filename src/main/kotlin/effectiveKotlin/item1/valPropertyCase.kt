package effectiveKotlin.item1

var name: String = "ryu"
var surname: String = "seungmin"
val fullName: String
    get() = "$name $surname"

fun calculate(): Int {
    print("calculate... ")
    return 41
}

val fizz = calculate()
val buzz
    get() = calculate()

val name2: String? = "ryu"
val surname2: String? = "seungmin"

val fullName2: String?
    get() = name2?.let { "$it $surname2" }

val fullName3: String? = name2?.let { "$it $surname2" }

fun main() {
    println(fullName) // ryu seungmin
    name = "ryu2"
    println(fullName) // ryu2 seungmin

    println(fizz) // 41
    println(fizz) // 41
    println(buzz) // calculate... 41
    println(buzz) // calculate... 41

    if (fullName2 != null) {
//        println(fullName2.length) // 오류 발생
        println(fullName2!!.length) // 스마트 캐스트가 안되서 명시적으로 해야함
    }

    if (fullName3 != null) {
        println(fullName3!!.length) // 굳이 !! 하지 않아도 스마트 캐스트됌
        println(fullName3.length) // 12
    }
}