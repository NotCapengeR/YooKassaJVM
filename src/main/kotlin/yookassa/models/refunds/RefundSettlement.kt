package yookassa.models.refunds

import yookassa.models.Amount

data class RefundSettlement(
    val type: String = "payout",
    val amount: Amount
)