package yookassa.models.shared.refunds

data class Deal(
    val refundSettlements: List<RefundSettlement>
): java.io.Serializable