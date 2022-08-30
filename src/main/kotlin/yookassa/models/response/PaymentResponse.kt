package yookassa.models.response

import yookassa.models.shared.Amount
import yookassa.models.shared.CancellationDetails
import yookassa.models.shared.Metadata
import yookassa.models.shared.Transfer

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
    val transfers: List<Transfer>? = null,
    val merchantCustomerId: String? = null
): java.io.Serializable

data class Recipient(val accountId: String, val gatewayId: String): java.io.Serializable

data class AuthorizationDetails(
    val rrn: String? = null,
    val authCode: String? = null,
    val threeDSecure: ThreeDSecure,
): java.io.Serializable

data class ThreeDSecure(val applied: Boolean): java.io.Serializable

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

sealed class Confirmation(val type: String): java.io.Serializable {

    data class Embedded(val token: String) : Confirmation(EMBEDDED)

    object External : Confirmation(EXTERNAL)

    data class MobileApplication(
        val confirmationUrl: String
    ) : Confirmation(MOBILE_APPLICATION)

    data class QRCode(val confirmationData: String) : Confirmation(QR_CODE)

    data class Redirect(
        val confirmationUrl: String,
        val enforce: Boolean? = null,
        val returnUrl: String? = null,
    ) : Confirmation(REDIRECT)


    private companion object {
        // Confirmation types
        private const val EMBEDDED: String = "embedded"
        private const val EXTERNAL: String = "external"
        private const val MOBILE_APPLICATION: String = "mobile_application"
        private const val QR_CODE: String = "qr"
        private const val REDIRECT: String = "redirect"

    }
}
