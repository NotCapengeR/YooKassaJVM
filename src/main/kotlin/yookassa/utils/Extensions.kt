package yookassa.utils

import java.math.BigDecimal
import java.math.BigInteger
import java.text.DecimalFormat

private val FORMAT = DecimalFormat("0.00")

fun Double.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun Float.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun Int.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun Long.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun Short.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun Byte.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

fun BigDecimal.toAmount(): String {
    return FORMAT.format(this.toDouble()).replace(".", ",")
}

val BigDecimal.TWO: BigDecimal
get() = BigDecimal(BigInteger.TWO)


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