package yookassa

import com.google.gson.Gson
import yookassa.models.*
import yookassa.models.Currency.*
import yookassa.models.item.Item
import yookassa.models.item.VatCode
import yookassa.models.refunds.Refund
import yookassa.models.refunds.Source

fun main() {

    val gson = Gson()

    val refund = Refund.Builder()
        .paymentId("paymentId")
        .amount(22.3, USD)
        .description("description")
        .receipt(
            Receipt(
                listOf(
                    Item.Builder()
                        .amount(12.00, RUB)
                        .description("description")
                        .quantity(10)
                        .vatCode(VatCode.VAT_0)
                        .build(),
                    Item.Builder()
                        .amount(12.00, RUB)
                        .description("description")
                        .vatCode(VatCode.VAT_0)
                        .quantity(10)
                        .build()
                )
            )
        )
        .sources(
            Source("acc id 1", amount(20.99, RUB)),
            Source("acc id 2", amount(199.99, EUR)),
        )
        .deal(
            amount(15.99, EUR),
            amount(22.99, USD)
        )
        .build()

    println(gson.toJson(refund))
}
