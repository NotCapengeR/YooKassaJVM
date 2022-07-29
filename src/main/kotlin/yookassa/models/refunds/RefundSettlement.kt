package yookassa.models.refunds

import yookassa.models.Amount

data class RefundSettlement(
    val amount: Amount,
    val type: String = REFUND_TYPE,
) {

    companion object {
        const val REFUND_TYPE: String = "payout"
    }
}