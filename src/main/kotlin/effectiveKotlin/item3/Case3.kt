package effectiveKotlin.item3

interface UserRepo {
    fun getUserName() = JavaClass().value
}

class RepoImpl: UserRepo {
    override fun getUserName(): String? {
        return null
    }
}

fun main() {
    val repo: UserRepo = RepoImpl()
    val text: String = repo.getUserName() // 런타임 시 NPE
    println("user name is ${text}")
}