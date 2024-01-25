package effectiveKotlin.item1

inline fun <T,R> Iterable<T>.map(
    transformation: (T) -> R
): List<R> {
    val list = ArrayList<R>()
    for (item in this) {
        list.add(transformation(item))
    }
    return list
}

val list = listOf(1,2,3,4,5)

fun main() {
    // 매우 위험한 코드, list 는 불변이지만 MutableList 로 다운 캐스팅되어 변경될 수 있음
    if (list is MutableList) {
        list.add(6) // 오류 발생
        // 위 코드는 플랫폼에 따라 다르게 동작하게 됌. JVM 에서 listOf 는 자바의 ArrayList 인스턴스를 리턴하기 때문에
        // MutableList 로 변경할 수 있지만 코틀린의 Arrays.ArrayList 는 이러한 연산을 구현하고 있지 않아서 오류 발생함
    }

    val mutableList = list.toMutableList()
    mutableList.add(6) // 정상 동작
}