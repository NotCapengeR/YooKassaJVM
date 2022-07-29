package yookassa.models.shared.refunds

import yookassa.models.shared.Amount
import yookassa.models.shared.CancellationDetails

data class RefundResponse(
    val id: String,
    val paymentId: String,
    val status: String,
    val cancellationDetails: CancellationDetails? = null,
    val receiptRegistration: String? = null,
    val createdAt: String,
    val amount: Amount,
    val description: String? = null,
    val sources: List<Source>? = null,
    val deal: Deal
)