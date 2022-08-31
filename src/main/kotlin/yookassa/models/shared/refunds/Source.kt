package yookassa.models.shared.refunds

import yookassa.models.shared.Amount
import kotlinx.serialization.Serializable

@Serializable
data class Source(
    val accountId: String,
    val amount: Amount,
    val platformFeeAmount: Amount? = null,
) : java.io.Serializable