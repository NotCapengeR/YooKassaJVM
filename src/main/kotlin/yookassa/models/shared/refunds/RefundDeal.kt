package yookassa.models.shared.refunds

import kotlinx.serialization.Serializable

@Serializable
data class RefundDeal(
    val refundSettlements: List<RefundSettlement>
): java.io.Serializable