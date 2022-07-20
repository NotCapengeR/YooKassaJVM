package youkassa.models

import youkassa.exceptions.PaymentNotInitializedException


data class Payment(
    val amount: Amount,
    val description: String? = null,
    val receipt: Receipt? = null,
    val recipient: Recipient? = null,
    val paymentToken: String? = null,
    val paymentMethodId: String? = null,
    val paymentMethodData: PaymentMethodData? = null,
    val confirmation: Confirmation? = null,
    val savePaymentMethod: Boolean? = null,
    val capture: Boolean? = null,
    val clientIp: String? = null,
    val metaData: Metadata? = null,
    val airline: Airline? = null,
    val transfers: List<Transfer>? = null,
    val deal: Deal? = null,
    val merchantCustomerId: String? = null
) {

    class Builder {
        private var payment: Payment = NULL_PAYMENT

        fun setAmount(amount: Amount): Builder {
            this.payment = this.payment.copy(amount = amount)
            return this
        }

        fun setAmount(value: Double, currency: String): Builder {
            return setAmount(Amount(value, currency))
        }

        fun description(description: String): Builder {
            this.payment = this.payment.copy(description = description)
            return this
        }

        fun recipient(recipient: Recipient): Builder {
            this.payment = this.payment.copy(recipient = recipient)
            return this
        }

        fun recipient(gatewayId: String): Builder {
            return recipient(Recipient(gatewayId))
        }

        fun create(value: Double, currency: String): Payment {
            return create(Amount(value, currency))
        }

        fun create(amount: Amount): Payment {
            return this.payment.copy(amount = amount)
        }

        fun build(): Payment {
            if (this.payment == NULL_PAYMENT) {
                throw PaymentNotInitializedException("Amount for payment is not defined!")
            }
            return this.payment
        }

        private companion object {
            private val NULL_AMOUNT: Amount = Amount(Double.NaN, "null")
            private val NULL_PAYMENT: Payment = Payment(
                amount = NULL_AMOUNT,
                description = null,
                receipt = null,
                recipient = null,
                paymentToken = null,
                paymentMethodId = null,
                paymentMethodData = null,
                confirmation = null,
                savePaymentMethod = null,
                capture = null,
                clientIp = null,
                metaData = null,
                airline = null,
                transfers = null,
                deal = null,
                merchantCustomerId = null
            )
        }
    }




    data class Receipt(
        val items: List<Item>,
        val customer: Customer? = null,
        val phone: String? = null,
        val email: String? = null,
        val taxSystemCode: Int? = null,
        val recipientIndustryDetails: List<ReceiptIndustryDetails>? = null,
        val recipientOperationalDetails: RecipientOperationalDetails? = null
    ) {

        data class Customer(
            val fullName: String? = null,
            val inn: Int? = null,
            val email: String? = null,
            val phone: String? = null
        )

        data class PaymentSubjectIndustryDetails(
            val federalId: String,
            val documentDate: String,
            val documentNumber: String,
            val value: String
        )

        data class MarkQuantity(val numerator: Int, val denominator: Int)

        data class MarkCodeInfo(
            val markCodeRaw: String? = null,
            val unknown: String? = null,
            val ean8: String? = null,
            val ean13: String? = null,
            val gs10: String? = null,
            val gs1m: String? = null,
            val short: String? = null,
            val fur: String? = null,
            val egais20: String? = null,
            val egais30: String? = null
        )

        data class ReceiptIndustryDetails(
            val federalId: String,
            val documentDate: String,
            val documentNumber: String,
            val value: String
        )

        data class RecipientOperationalDetails(
            val operationId: Int,
            val value: String,
            val createdAt: String
        )

        data class Item(
            val amount: Amount,
            val description: String,
            val quantity: Int,
            val vatCode: Int,
            val measure: String? = null,
            val markQuantity: MarkQuantity? = null,
            val paymentSubject: String? = null,
            val paymentMode: String? = null,
            val countyOfOriginMode: String? = null,
            val customerDeclarationNumber: String? = null,
            val excise: String? = null,
            val productCode: String? = null,
            val markCodeInfo: MarkCodeInfo? = null,
            val markMode: String? = null,
            val paymentSubjectIndustryDetails: List<PaymentSubjectIndustryDetails>? = null
        )

    }


    data class Recipient(val gatewayId: String)

    data class Airline(
        val ticketNumber: String? = null,
        val bookingReference: String? = null,
        val passengers: List<Passenger>? = null,
        val legs: List<Leg>? = null
    ) {

        data class Leg(
            val departureAirport: String,
            val destinationAirport: String,
            val departureDate: String,
            val carriedCode: String? = null
        )

        data class Passenger(
            val firstname: String,
            val lastname: String
        )
    }

    data class Card(
        val number: String,
        val expiryYeah: String,
        val expiryMonth: String,
        val csc: String? = null,
        val cardholder: String? = null
    )

    sealed class PaymentMethodData(val type: String) {

        data class AlfaClick(val login: String? = null) : PaymentMethodData(ALFA_CLICK)

        data class MobileBalance(val phone: String) : PaymentMethodData(MOBILE_BALANCE)

        data class BankCard(val card: Card? = null) : PaymentMethodData(BANK_CARD)

        object Installments : PaymentMethodData(INSTALLMENTS)

        data class Cash(val phone: String? = null) : PaymentMethodData(CASH)

        object SBP : PaymentMethodData(SBP_PAYMENT_TYPE)

        data class SberBankBusinessOnline(val paymentPurpose: String, val vatData: VatData)
            : PaymentMethodData(SBERBANK_BUSINESS_ONLINE)

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

    sealed class Confirmation(val type: String) {

        data class Embedded(val locale: String? = null) : Confirmation(EMBEDDED)

        data class External(val locale: String? = null) : Confirmation(EXTERNAL)

        data class MobileApplication(
            val returnUrl: String,
            val locale: String? = null
        ) : Confirmation(MOBILE_APPLICATION)

        data class QRCode(val locale: String? = null) : Confirmation(QR_CODE)

        data class Redirect(
            val returnUrl: String,
            val locale: String? = null,
            val enforce: Boolean? = null
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
