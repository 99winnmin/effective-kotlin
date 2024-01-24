package effectiveKotlin.item3

fun statedType() {
    val value: String = JavaClass().value // NPE 발생
    // ...
    println(value.length)
}

fun platformType() {
    val value = JavaClass().value
    // ...
    println(value.length) // NPE 발생
}