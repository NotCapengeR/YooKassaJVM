package yookassa.utils

import yookassa.models.shared.Amount
import yookassa.models.shared.Currencies
import java.math.BigDecimal
import java.text.DecimalFormat

private val FORMAT = DecimalFormat("#.00")

fun amount(value: Double, currency: Currencies): Amount {
    if (value < 0) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $value")
    }
    return Amount(value.toAmount(), currency.name)
}

fun Double.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $this")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Float.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $this")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Int.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $this")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Long.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $this")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Short.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $this")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun Byte.toAmount(): String {
    if (this < 0) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $this")
    }
    return FORMAT.format(this).replace(".", ",")
}

fun BigDecimal.toAmount(): String {
    if (this < BigDecimal(0)) {
        throw IllegalArgumentException("Amount can't has negative value! Given value: $this")
    }
    return FORMAT.format(this.toDouble()).replace(".", ",")
}

fun UInt.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun UShort.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun ULong.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun UByte.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}