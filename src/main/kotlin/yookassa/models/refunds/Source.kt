package yookassa.models.refunds

import yookassa.models.Amount

data class Source(
    val accountId: String,
    val amount: Amount,
    val platformFeeAmount: Amount? = null,
)