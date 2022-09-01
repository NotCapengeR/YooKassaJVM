package yookassa

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import yookassa.models.request.Confirmation
import yookassa.models.request.PaymentMethodData
import yookassa.models.request.PaymentRequest
import yookassa.models.shared.Amount
import yookassa.models.shared.Currencies
import yookassa.models.shared.item.Item
import yookassa.models.shared.item.Measure
import yookassa.models.shared.item.VatCode
import yookassa.models.shared.receipt.Receipt

fun main() {
    val format = Json { prettyPrint = true }
    YooKassaConfig.setDefaultCurrency(Currencies.RUB)



    val item = Item.Builder()
        .amount(Amount.fromValue(200))
        .description("description")
        .quantity(2)
        .measure(Measure.CENTIMETER)
        .vatCode(VatCode.VAT_10)
        .build()

    val item2 = Item.Builder()
        .amount(Amount.fromValue(300))
        .description("description")
        .quantity(1)
        .measure(Measure.CENTIMETER)
        .vatCode(VatCode.VAT_10)
        .build()

    val payment: PaymentRequest = PaymentRequest.Builder(103.23)
        .description("Hueta")
        .paymentMethodData(PaymentMethodData.SBP)
        .recipient("13232312132")
        .merchantCustomerId("1313212")
        .confirmation(Confirmation.Redirect("https://.../"))
        .receipt(Receipt.Builder()
            .setItems(listOf(item, item2))
            .build()
        )
        .build()




    println(format.encodeToString(payment))
}
