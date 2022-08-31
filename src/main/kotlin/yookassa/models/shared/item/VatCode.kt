package yookassa.models.shared.item

import kotlinx.serialization.Serializable

@Serializable
enum class VatCode : java.io.Serializable {
    NULL, NONE, VAT_0, VAT_10, VAT_RECEIPT_20, VAT_RECEIPT_CALC_110, VAT_RECEIPT_CALC_120
}