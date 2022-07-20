package yookassa

import com.google.gson.Gson
import yookassa.models.Currencies
import yookassa.models.Payment

fun main() {

    val gson = Gson()

    val payment = Payment.Builder()
        .setAmount(1.0, Currencies.RUB)
        .description("Hueta")
        .recipient("recipient")
        .build()

    println(gson.toJson(payment))
}
