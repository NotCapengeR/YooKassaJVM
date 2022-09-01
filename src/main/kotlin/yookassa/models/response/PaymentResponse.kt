package yookassa.models.response

import kotlinx.serialization.SerialName
import yookassa.models.shared.Amount
import yookassa.models.shared.CancellationDetails
import yookassa.models.shared.Metadata
import yookassa.models.shared.PaymentTransfer
import kotlinx.serialization.Serializable

@Serializable
data class PaymentResponse(
    val id: String,
    val status: String,
    val amount: Amount,
    val incomeAmount: Amount,
    val description: String? = null,
    val recipient: Recipient,
    val paymentMethod: PaymentMethod,
    val capturedAt: String,
    val createdAt: String? = null,
    val expiresAt: String? = null,
    val confirmation: Confirmation,
    val test: Boolean,
    val refundedAmount: Amount? = null,
    val paid: Boolean,
    val refundable: Boolean,
    val receiptRegistration: String? = null,
    val metadata: Metadata? = null,
    val cancellationDetails: CancellationDetails? = null,
    val authorizationDetails: AuthorizationDetails? = null,
    val transfers: List<PaymentTransfer>? = null,
    val merchantCustomerId: String? = null
): java.io.Serializable

@Serializable
data class Recipient(val accountId: String, val gatewayId: String): java.io.Serializable

@Serializable
data class AuthorizationDetails(
    val rrn: String? = null,
    val authCode: String? = null,
    val threeDSecure: ThreeDSecure,
): java.io.Serializable

@Serializable
data class ThreeDSecure(val applied: Boolean): java.io.Serializable

@Serializable
data class PayoutBankDetails(
    val fullName: String,
    val shortName: String,
    val address: String,
    val inn: String,
    val bankName: String,
    val bankBranch: String,
    val bankBik: String,
    val account: String,
    val kpp: String? = null
): java.io.Serializable

@Serializable
sealed class Confirmation : java.io.Serializable {

    @Serializable
    @SerialName(EMBEDDED)
    data class Embedded(val token: String) : Confirmation()

    @Serializable
    @SerialName(EXTERNAL)
    object External : Confirmation()

    @Serializable
    @SerialName(MOBILE_APPLICATION)
    data class MobileApplication(
        val confirmationUrl: String
    ) : Confirmation()

    @Serializable
    @SerialName(QR_CODE)
    data class QRCode(val confirmationData: String) : Confirmation()

    @Serializable
    @SerialName(REDIRECT)
    data class Redirect(
        val confirmationUrl: String,
        val enforce: Boolean? = null,
        val returnUrl: String? = null,
    ) : Confirmation()


    companion object {
        // Confirmation types
        const val EMBEDDED: String = "embedded"
        const val EXTERNAL: String = "external"
        const val MOBILE_APPLICATION: String = "mobile_application"
        const val QR_CODE: String = "qr"
        const val REDIRECT: String = "redirect"

    }
}
