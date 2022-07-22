package yookassa.utils

import java.math.BigDecimal
import java.text.DecimalFormat

private val FORMAT = DecimalFormat("#.00")

fun Double.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Float.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Int.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Long.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Short.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Byte.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun BigDecimal.toAmount(): String {
    if (this < BigDecimal(0)) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this.toDouble()).replace(".", ",")
}