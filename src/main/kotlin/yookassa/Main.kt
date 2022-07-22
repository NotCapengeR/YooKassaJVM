package yookassa

import com.google.gson.Gson
import yookassa.models.*
import yookassa.models.item.CountryOfOriginMode
import yookassa.models.item.Item
import yookassa.models.item.Measure
import yookassa.models.item.VatCode

fun main() {

    val gson = Gson()

    val item = Item.Builder()
        .amount(10.0, Currencie.RUB)
        .description("description")
        .quantity(2)
        .vatCode(VatCode.VAT_10)
        .measure(Measure.PIECE)
        .excise("blblbl")
        .countyOfOriginMode(CountryOfOriginMode.RU)
        .markQuantity(1, 20)
        .build()

    println(gson.toJson(item))
}
