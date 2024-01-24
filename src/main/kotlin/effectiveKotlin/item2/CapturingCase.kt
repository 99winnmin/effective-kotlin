package effectiveKotlin.item2

fun main() {
//    algo1()
//    algo1V2()
    algo1V3()
}

fun algo1() {
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while (numbers.isNotEmpty()) {
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0 }
    }
    print(primes)
    //[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
}

fun algo1V2() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers
                            .drop(1)
                            .filter { it % prime != 0 }
        }
    }
    print(primes.take(10).toList())
    //[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
}

// 캡쳐링 이슈 발생
fun algo1V3() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        var prime: Int
        while (true) {
            prime = numbers.first()
            yield(prime)
            numbers = numbers
                            .drop(1)
                            .filter { it % prime != 0 }
        }
    }
    print(primes.take(10).toList())
//    [2, 3, 5, 6, 7, 8, 9, 10, 11, 12]
}
