package yookassa.models.response

import kotlinx.serialization.SerialName
import yookassa.models.shared.PaymentStatus
import kotlinx.serialization.Serializable
import yookassa.models.shared.Settlement
import yookassa.models.shared.receipt.ReceiptIndustryDetails
import yookassa.models.shared.receipt.ReceiptItem
import yookassa.models.shared.receipt.RecipientOperationalDetails

@Serializable
data class ReceiptResponse(
    @SerialName("id") val id: String,
    @SerialName("type") val type: String,
    @SerialName("payment_id") val paymentId: String? = null,
    @SerialName("refund_id") val refundId: String? = null,
    @SerialName("status") val status: String,
    @SerialName("fiscal_document_number") val fiscalDocumentNumber: String? = null,
    @SerialName("fiscal_storage_number") val fiscalStorageNumber: String? = null,
    @SerialName("fiscal_attribute") val fiscalAttribute: String? = null,
    @SerialName("registered_at") val requestedAt: String? = null,
    @SerialName("fiscal_provider_id") val fiscalProviderId: String? = null,
    @SerialName("items") val items: List<ReceiptItem>? = null,
    @SerialName("settlements") val settlements: List<Settlement>? = null,
    @SerialName("on_behalf_of") val onBehalfOn: String? = null,
    @SerialName("tax_system_code") val taxSystemCode: Int? = null,
    @SerialName("receipt_industry_details") val receiptIndustryDetails: List<ReceiptIndustryDetails>? = null,
    @SerialName("receipt_operational_details") val receiptOperationsDetails: RecipientOperationalDetails? = null
): java.io.Serializable


