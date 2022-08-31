package yookassa.models.shared.refunds

import yookassa.models.shared.Amount

import kotlinx.serialization.Serializable

@Serializable
data class RefundSettlement(
    val amount: Amount,
    val type: String = REFUND_TYPE,
): java.io.Serializable {

    companion object {
        const val REFUND_TYPE: String = "payout"
    }
}