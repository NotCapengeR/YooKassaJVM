package yookassa.models

import java.text.DecimalFormat

fun Double.toAmount()  : String {
    if (this < 0) throw RuntimeException("Amount can't has negative value")
    val format = DecimalFormat("#.00")
    return format.format(this).replace(".", ",")
}

fun amount(value: Double, currency: Currency): Amount {
    if (value < 0) throw RuntimeException("Amount can't has negative value")
    return Amount(value.toAmount(), currency.name)
}