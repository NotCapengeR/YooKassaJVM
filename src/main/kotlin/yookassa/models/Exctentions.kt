package yookassa.models

import java.text.DecimalFormat

fun Double.toAmount()  : String {
    if (this < 0) throw RuntimeException("amount can't has negative value")
    val format = DecimalFormat("#.00")
    return format.format(this).replace(".", ",")
}
