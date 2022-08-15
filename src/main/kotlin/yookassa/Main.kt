package yookassa

import com.google.gson.Gson
import yookassa.models.request.Confirmation
import yookassa.models.request.Payment
import yookassa.models.request.PaymentMethodData
import yookassa.models.request.Receipt
import yookassa.models.shared.Amount
import yookassa.models.shared.item.Item
import yookassa.models.shared.item.VatCode
import yookassa.models.shared.Currencies
import yookassa.models.shared.item.Measure

fun main() {

    val gson = Gson()

    YooKassaConfig.setDefaultCurrency(Currencies.RUB)

    val item = Item.Builder()
        .amount(10.0, Currencies.RUB)
        .description("description")
        .quantity(2)
        .measure(Measure.CENTIMETER)
        .vatCode(VatCode.VAT_10)
        .build()

    val item2 = item.copy(amount = Amount("300.0", Currencies.RUB.toString()), quantity = 5)

    val payment = Payment.Builder(103.23)
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



    println(gson.toJson(payment))
}
