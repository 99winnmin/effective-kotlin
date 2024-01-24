package effectiveKotlin.item2

// 나쁜 예
fun updateWeather(degress: Int) {
    val description: String
    val color: Int
    if (degress < 5) {
        description = "cold"
        color = 0x0000FF
    } else if (degress > 23) {
        description = "hot"
        color = 0xFF0000
    } else {
        description = "mild"
        color = 0x00FF00
    }
}

// 조금 더 좋은 예
fun updateWeather2(degress: Int) {
    val (description, color) = when {
        degress < 5 -> "cold" to 0x0000FF
        degress > 23 -> "hot" to 0xFF0000
        else -> "mild" to 0x00FF00
    }
}