package yookassa.models.shared.refunds

import kotlinx.serialization.Serializable

@Serializable
data class Deal(
    val refundSettlements: List<RefundSettlement>
): java.io.Serializable