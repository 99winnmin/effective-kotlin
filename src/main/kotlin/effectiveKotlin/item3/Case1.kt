package effectiveKotlin.item3

// 코틀린이 디폴트로 모든 타입을 nullable 로 다룬다면,
// 우리는 이를 사용할 때 이러한 리스트와 리스트 내부의 User 객체들이 널이 아니라는 것을 알아야함
// 따라서 리스트 자체만 널인지 확인해서는 안되고, 그 내부에 있는 것들도 널인지 확인해야함
val users: List<User> = UserRepo().users!!.filterNotNull()

// 리스트는 적어도 map, filterNotNull 등의 메서드를 제공하지만 다른 제네릭 타입이라면 널을 확인하는 것이 정말 복잡한 일임
val groupedUsers: List<List<User>> = UserRepo().groupedUsers!!
    .map { it!!.filterNotNull() }

val repo = UserRepo()
// 코틀린은 자바 등의 다른 언어에서 넘어온 타입들을 특수하게 다루는데 이를 플랫폼 타입이라고 부름
// 플랫폼 타입이란 다른 언어에서 넘어와서 nullable 인지 아닌지 알 수 없는 타입
val user1 = repo.user // user1 의 타입은 User!
val user2: User = repo.user // user2 의 타입은 User
val user3: User? = repo.user // user3 의 타입은 User?

// 플랫폼 타입을 사용하지 않고 nullable 임을 가정하고 명시함
val users1: List<User> = UserRepo().users
val groupedUsers1: List<List<User>> = UserRepo().groupedUsers

