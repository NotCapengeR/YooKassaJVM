package yookassa.models.response

import yookassa.models.VatData

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
        val payoutBankDetails: PaymentResponse.PayoutBankDetails? = null,
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