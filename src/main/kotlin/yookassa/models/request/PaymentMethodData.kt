package yookassa.models.request

import yookassa.models.VatData

sealed class PaymentMethodData(val type: String) {

    data class AlfaClick(val login: String? = null) : PaymentMethodData(ALFA_CLICK)

    data class MobileBalance(val phone: String) : PaymentMethodData(MOBILE_BALANCE)

    data class BankCard(val card: Card? = null) : PaymentMethodData(BANK_CARD)

    object Installments : PaymentMethodData(INSTALLMENTS)

    data class Cash(val phone: String? = null) : PaymentMethodData(CASH)

    object SBP : PaymentMethodData(SBP_PAYMENT_TYPE)

    data class SberBankBusinessOnline(val paymentPurpose: String, val vatData: VatData) :
        PaymentMethodData(SBERBANK_BUSINESS_ONLINE)

    object Tinkoff : PaymentMethodData(TINFOFF_BANK)

    object YooMoney : PaymentMethodData(YOO_MONEY)

    data class QIWI(val phone: String? = null) : PaymentMethodData(QIWI_METHOD_DATA)

    data class SberPay(val phone: String? = null) : PaymentMethodData(SBERPAY)

    private companion object {
        //  Payment method data types
        private const val ALFA_CLICK: String = "alfabank"
        private const val MOBILE_BALANCE: String = "mobile_balance"
        private const val BANK_CARD: String = "bank_card"
        private const val INSTALLMENTS: String = "installments"
        private const val CASH: String = "cash"
        private const val SBP_PAYMENT_TYPE: String = "sbp"
        private const val SBERBANK_BUSINESS_ONLINE: String = "b2b_sberbank"
        private const val TINFOFF_BANK: String = "tinkoff_bank"
        private const val YOO_MONEY: String = "yoo_money"
        private const val QIWI_METHOD_DATA: String = "qiwi"
        private const val SBERPAY: String = "sberbank"
    }

}