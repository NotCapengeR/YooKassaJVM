import models.Payment

fun main() {

    val payment = Payment.Builder()
        .setAmount(1.0, "RUB")
        .description("Hueta")
        .recipient("recipient")
        .build()

    println(payment)
}