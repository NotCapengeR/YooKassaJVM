package yookassa.models.shared

import kotlinx.serialization.Serializable

@Serializable
enum class TaxSystemCode(val code: Int): java.io.Serializable {
    NO_VAT(1), VAT_0(2), VAT_10(3), VAT_WAITING_FOR_ITEMS20(4),
    VAT_CHECK_ESTIMATED_RATE10110(5), VAT_CHECK_ESTIMATED_RATE20120(6),
}