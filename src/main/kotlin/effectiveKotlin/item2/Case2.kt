package effectiveKotlin.item2

// 나쁜 예
fun badCase2(hasValue: Boolean) {
    val user: User
    if (hasValue) {
        user = getValue()
    } else {
        User()
    }
}

// 조금 더 좋은 예
fun betterCase2(hasValue: Boolean) {
    val user: User = if (hasValue) {
        getValue()
    } else {
        User()
    }
}

fun getValue(): User {
    return User()
}