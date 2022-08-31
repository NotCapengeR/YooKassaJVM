package yookassa.utils

import java.math.BigDecimal
import java.math.BigInteger
import java.text.DecimalFormat

private val FORMAT = DecimalFormat("0.00")

internal fun Double.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun Float.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun Int.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun Long.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun Short.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun Byte.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun BigDecimal.toAmount(): String {
    return FORMAT.format(this.toDouble()).replace(".", ",")
}

val BigDecimal.TWO: BigDecimal
    get() = BigDecimal(BigInteger.TWO)


internal fun UInt.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun UShort.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun ULong.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}

internal fun UByte.toAmount(): String {
    return FORMAT.format(this).replace(".", ",")
}