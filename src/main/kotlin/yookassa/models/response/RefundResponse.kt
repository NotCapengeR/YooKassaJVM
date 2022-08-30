package yookassa.models.response

import yookassa.models.shared.Amount
import yookassa.models.shared.CancellationDetails
import yookassa.models.shared.refunds.Deal
import yookassa.models.shared.refunds.Source

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
): java.io.Serializable