package effectiveKotlin.item2

val users: List<User> = listOf(User(), User())

fun main() {
    badCase()
    betterCase()
    bestCase()
}

fun badCase() {
    // 나쁜 예
    var user: User
    for (i in users.indices) {
        user = users[i]
        print("user at $i in $user")
    }
}

fun betterCase() {
    // 조금 더 좋은 예
    for (i in users.indices) {
        val user = users[i]
        print("user at $i in $user")
    }
}


fun bestCase() {
    // 제일 좋은 예
    for ((i, user) in users.withIndex()) {
        print("user at $i in $user")
    }
}