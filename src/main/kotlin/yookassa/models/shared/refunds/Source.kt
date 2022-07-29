package yookassa.models.shared.refunds

import yookassa.models.shared.Amount

data class Source(
    val accountId: String,
    val amount: Amount,
    val platformFeeAmount: Amount? = null,
)