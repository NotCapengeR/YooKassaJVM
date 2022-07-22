package yookassa

import com.google.gson.Gson
import yookassa.models.*
import yookassa.models.item.Item

fun main() {

    val gson = Gson()

    val item = Item.Builder()
        .amount(10.0, Currencies.RUB)
        .description("description")
        .quantity(2)
        .vatCode(Item.VatCode.VAT_10)
        .build()

    println(gson.toJson(item))
}
