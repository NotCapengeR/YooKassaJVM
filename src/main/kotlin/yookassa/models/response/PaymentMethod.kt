package yookassa.models.response

import kotlinx.serialization.SerialName
import yookassa.models.shared.VatData
import kotlinx.serialization.Serializable

@Serializable
sealed class PaymentMethod : java.io.Serializable {

    @Serializable
    @SerialName(ALFA_CLICK)
    data class AlfaClick(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
        val login: String? = null,
    ) : PaymentMethod()

    @Serializable
    @SerialName(MOBILE_BALANCE)
    data class MobileBalance(
        val id: String,
        val saved: Boolean,
        val title: String? = null
    ) : PaymentMethod()

    @Serializable
    @SerialName(BANK_CARD)
    data class BankCard(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
        val card: PaymentMethodCard? = null
    ) : PaymentMethod()


    @Serializable
    @SerialName(INSTALLMENTS)
    data class Installments(
        val id: String,
        val saved: Boolean,
        val title: String? = null
    ) : PaymentMethod()


    @Serializable
    @SerialName(CASH)
    data class Cash(
        val id: String,
        val saved: Boolean,
        val title: String? = null
    ) : PaymentMethod()


    @Serializable
    @SerialName(SBP_PAYMENT_TYPE)
    data class SBP(
        val id: String,
        val saved: Boolean,
        val title: String? = null
    ) : PaymentMethod()


    @Serializable
    @SerialName(SBERBANK_BUSINESS_ONLINE)
    data class SberBankBusinessOnline(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
        val payoutBankDetails: PayoutBankDetails? = null,
        val paymentPurpose: String,
        val vatData: VatData,
    ) : PaymentMethod()

    @Serializable
    @SerialName(TINFOFF_BANK)
    data class Tinkoff(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
    ) : PaymentMethod()

    @Serializable
    @SerialName(YOO_MONEY)
    data class YooMoney(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
        val accountNumber: String? = null
    ) : PaymentMethod()

    @Serializable
    @SerialName(APPLE_PAY)
    data class ApplePay(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
    ) : PaymentMethod()

    @Serializable
    @SerialName(GOOGLE_PAY)
    data class GooglePay(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
    ) : PaymentMethod()

    @Serializable
    @SerialName(QIWI_METHOD_DATA)
    data class QIWI(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
    ) : PaymentMethod()

    @Serializable
    @SerialName(SBERPAY)
    data class SberPay(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
        val card: Card? = null,
        val phone: String? = null
    ) : PaymentMethod() {

        @Serializable
        data class Card(
            val bin: String? = null,
            val last4: String,
            val expiryYear: String,
            val expiryMonth: String,
            val cardType: String
        )
    }

    @Serializable
    @SerialName(WE_CHAT)
    data class WeChat(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
    ) : PaymentMethod()

    @Serializable
    @SerialName(WEB_MONEY)
    data class WebMoney(
        val id: String,
        val saved: Boolean,
        val title: String? = null,
    ) : PaymentMethod()


    companion object {
        // Payment methods types
        const val ALFA_CLICK: String = "alfabank"
        const val MOBILE_BALANCE: String = "mobile_balance"
        const val BANK_CARD: String = "bank_card"
        const val INSTALLMENTS: String = "installments"
        const val CASH: String = "cash"
        const val SBP_PAYMENT_TYPE: String = "sbp"
        const val SBERBANK_BUSINESS_ONLINE: String = "b2b_sberbank"
        const val TINFOFF_BANK: String = "tinkoff_bank"
        const val YOO_MONEY: String = "yoo_money"
        const val APPLE_PAY: String = "apple_pay"
        const val GOOGLE_PAY: String = "google_pay"
        const val QIWI_METHOD_DATA: String = "qiwi"
        const val SBERPAY: String = "sberbank"
        const val WE_CHAT: String = "wechat"
        const val WEB_MONEY: String = "webmoney"
    }
}


@Serializable
data class PaymentMethodCard(
    val bin: String? = null,
    val last4: String,
    val expiryYear: String,
    val expiryMonth: String,
    val cardType: String? = null,
    val issuerCountry: String? = null,
    val issuerName: String? = null,
    val source: String? = null
)