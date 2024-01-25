package effectiveKotlin.item1

data class User(val name: String)

class UserRepository {
    private val storedUsers: MutableMap<Int, String> = mutableMapOf()

    fun loadAll() : MutableMap<Int, String> {
        return storedUsers
    }

}

val userRepository = UserRepository()
val storedUsers = userRepository.loadAll()

// 위험상황 방어하기 1 : 리턴되는 mutable 객체를 복제하기
class UserHolder(private val user: MutableUser) {
    fun get(): MutableUser {
        return user.copy()
    }
}

// 위험상황 방어하기 2 : 불변 객체로 변환하기
class UserRepository2 {
    private val storedUsers: MutableMap<Int, MutableUser> = mutableMapOf()

    fun loadAll() : Map<Int, MutableUser> {
        return storedUsers
    }

}

data class MutableUser(val name: String)

fun main() {
    storedUsers[4] = "ryu"
    println(storedUsers) // 돌발적인 수정이 일어날 때 위험함
}