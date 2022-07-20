package models

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
) {
    data class Recipient(val accountId: String, val gatewayId: String)

    data class CancellationDetails(
        val party: String,
        val reason: String,
    )

    data class AuthorizationDetails(
        val rrn: String? = null,
        val authCode: String? = null,
        val threeDSecure: ThreeDSecure,
    ) {
        data class ThreeDSecure(val applied: Boolean)
    }

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
    )

    sealed class PaymentMethod(val type: String) {

        data class AlfaClick(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
            val login: String? = null,
        ) : PaymentMethod(ALFA_CLICK)

        data class MobileBalance(
            val id: String,
            val saved: Boolean,
            val title: String? = null
        ) : PaymentMethod(MOBILE_BALANCE)

        data class BankCard(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
            val card: Card? = null
        ) : PaymentMethod(BANK_CARD) {
            data class Card(
                val BIN: String? = null,
                val last4: String,
                val expiryYear: String,
                val expiryMonth: String,
                val cardType: String? = null,
                val issuerCountry: String? = null,
                val issuerName: String? = null,
                val source: String? = null
            )
        }

        data class Installments(
            val id: String,
            val saved: Boolean,
            val title: String? = null
        ) : PaymentMethod(INSTALLMENTS)

        data class Cash(
            val id: String,
            val saved: Boolean,
            val title: String? = null
        ) : PaymentMethod(CASH)

        data class SBP(
            val id: String,
            val saved: Boolean,
            val title: String? = null
        ) : PaymentMethod(SBP_PAYMENT_TYPE)

        data class SberBankBusinessOnline(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
            val payoutBankDetails: PayoutBankDetails? = null,
            val paymentPurpose: String,
            val vatData: VatData,
        ) : PaymentMethod(SBERBANK_BUSINESS_ONLINE)

        data class Tinkoff(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
        ) : PaymentMethod(TINFOFF_BANK)

        data class YooMoney(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
            val accountNumber: String? = null
        ) : PaymentMethod(YOO_MONEY)

        data class ApplePay(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
        ) : PaymentMethod(APPLE_PAY)

        data class GooglePay(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
        ) : PaymentMethod(GOOGLE_PAY)

        data class QIWI(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
        ) : PaymentMethod(QIWI_METHOD_DATA)

        data class SberPay(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
            val card: Card? = null,
            val phone: String? = null
        ) : PaymentMethod(SBERPAY) {

            data class Card(
                val BIN: String? = null,
                val last4: String,
                val expiryYear: String,
                val expiryMonth: String,
                val cardType: String
            )
        }

        data class WeChat(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
        ) : PaymentMethod(WE_CHAT)

        data class WebMoney(
            val id: String,
            val saved: Boolean,
            val title: String? = null,
        ) : PaymentMethod(WEB_MONEY)


        private companion object {
            // Payment methods types
            private const val ALFA_CLICK: String = "alfabank"
            private const val MOBILE_BALANCE: String = "mobile_balance"
            private const val BANK_CARD: String = "bank_card"
            private const val INSTALLMENTS: String = "installments"
            private const val CASH: String = "cash"
            private const val SBP_PAYMENT_TYPE: String = "sbp"
            private const val SBERBANK_BUSINESS_ONLINE: String = "b2b_sberbank"
            private const val TINFOFF_BANK: String = "tinkoff_bank"
            private const val YOO_MONEY: String = "yoo_money"
            private const val APPLE_PAY: String = "apple_pay"
            private const val GOOGLE_PAY: String = "google_pay"
            private const val QIWI_METHOD_DATA: String = "qiwi"
            private const val SBERPAY: String = "sberbank"
            private const val WE_CHAT: String = "wechat"
            private const val WEB_MONEY: String = "webmoney"
        }
    }

    sealed class Confirmation(val type: String) {

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
}
