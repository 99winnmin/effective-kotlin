package effectiveKotlin.item3

interface UserRepoIF {
    fun getUserName() = JavaClass().value
}

class RepoImpl: UserRepoIF {
    override fun getUserName(): String? {
        return null
    }
}

fun main() {
    val repo: UserRepoIF = RepoImpl()
    val text: String = repo.getUserName() // 런타임 시 NPE
    println("user name is ${text}")
}