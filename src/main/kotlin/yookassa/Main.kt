package yookassa

import com.google.gson.Gson
import yookassa.models.shared.item.Item
import yookassa.models.shared.item.VatCode
import yookassa.models.shared.Currencies

fun main() {

    val gson = Gson()

    val item = Item.Builder()
        .amount(10.0, Currencies.RUB)
        .description("description")
        .quantity(2)
        .vatCode(VatCode.VAT_10)
        .build()

    println(gson.toJson(item))
}
