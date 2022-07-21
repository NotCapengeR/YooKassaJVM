package yookassa.utils

import java.text.DecimalFormat

private val FORMAT = DecimalFormat("#.00")

fun Double.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("amount can't has negative value")
    }
    return FORMAT.format(this).replace(".", ",")
}
