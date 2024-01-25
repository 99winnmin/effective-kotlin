package effectiveKotlin.item1

class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @Throws(InsufficientFundsException::class)
    fun withdraw(withdrawAmount: Double) {
        if (balance < withdrawAmount) {
            throw InsufficientFundsException()
        }
        balance -= withdrawAmount
    }
}

class InsufficientFundsException : Exception()
val bankAccount = BankAccount()

fun main() {
    println("잔액: ${bankAccount.balance}")
    bankAccount.deposit(100.0)
    println("잔액: ${bankAccount.balance}")
    bankAccount.withdraw(50.0)
}