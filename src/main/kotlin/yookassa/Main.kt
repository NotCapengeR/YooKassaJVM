package yookassa

import com.google.gson.Gson
import yookassa.models.Amount
import yookassa.models.Currencies
import yookassa.models.Payment
import yookassa.models.Receipt

fun main() {

    val gson = Gson()
    Config.setDefaultCurrency(Currencies.RUB)

    val payment = Payment.Builder()
        .setAmount(1000.326)
        .description("Hueta")
        .recipient("recipient")
        .receipt(
            Receipt(
            listOf(
                Receipt.Item(
                    amount = Amount("10.0", "RUB"),
                    description = "description",
                    quantity = 2,
                    vatCode = 1
                ),
                Receipt.Item(
                    amount = Amount("20.0", "RUB"),
                    description = "abalbal",
                    quantity = 5,
                    vatCode = 1
                    )
            )
        ))
        .confirmation(
            Payment.Confirmation.Redirect(
                returnUrl = "https://.......com"
            )
        )
        .build()

    println(gson.toJson(payment))
}
