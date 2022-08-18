package yookassa.models.request

import yookassa.YooKassaConfig
import yookassa.models.shared.*
import yookassa.utils.toAmount
import java.math.BigDecimal

data class PaymentRequest(
    val amount: Amount,
    val description: String? = null,
    val receipt: ReceiptRequest? = null,
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

    private constructor(builder: Builder) : this(
        amount = builder.amount,
        description = builder.description,
        receipt = builder.receipt,
        recipient = builder.recipient,
        paymentToken = builder.paymentToken,
        paymentMethodId = builder.paymentMethodId,
        paymentMethodData = builder.paymentMethodData,
        confirmation = builder.confirmation,
        savePaymentMethod = builder.savePaymentMethod,
        capture = builder.capture,
        clientIp = builder.clientIp,
        metaData = builder.metaData,
        airline = builder.airline,
        transfers = builder.transfers,
        deal = builder.deal,
        merchantCustomerId = builder.merchantCustomerId
    )

    class Builder(
        internal val amount: Amount
    ) {
        internal var description: String? = null
            private set
        internal var receipt: ReceiptRequest? = null
            private set
        internal var recipient: Recipient? = null
            private set
        internal var paymentToken: String? = null
            private set
        internal var paymentMethodId: String? = null
            private set
        internal var paymentMethodData: PaymentMethodData? = null
            private set
        internal var confirmation: Confirmation? = null
            private set
        internal var savePaymentMethod: Boolean? = null
            private set
        internal var capture: Boolean? = null
            private set
        internal var clientIp: String? = null
            private set
        internal var metaData: Metadata? = null
            private set
        internal var airline: Airline? = null
            private set
        internal var transfers: List<Transfer>? = null
            private set
        internal var deal: Deal? = null
            private set
        internal var merchantCustomerId: String? = null
            private set

        @JvmOverloads
        public constructor(
            value: Double,
            currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY
        ) : this(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        public constructor(
            value: Float,
            currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY
        ) : this(Amount(value.toAmount(), currency.name))


        @JvmOverloads
        public constructor(
            value: Short,
            currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY
        ) : this(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        public constructor(
            value: Int,
            currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY
        ) : this(Amount(value.toAmount(), currency.name))


        @JvmOverloads
        public constructor(
            value: Byte,
            currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY
        ) : this(Amount(value.toAmount(), currency.name))


        @JvmOverloads
        public constructor(
            value: Long,
            currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY
        ) : this(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        public constructor(
            value: BigDecimal,
            currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY
        ) : this(Amount(value.toAmount(), currency.name))


        fun description(description: String?): Builder = apply { this.description = description }

        fun recipient(recipient: Recipient?): Builder = apply { this.recipient = recipient }

        fun recipient(gatewayId: String): Builder = recipient(Recipient(gatewayId))

        fun receipt(receipt: ReceiptRequest?): Builder = apply { this.receipt = receipt }

        fun confirmation(confirmation: Confirmation?): Builder = apply { this.confirmation = confirmation }

        fun create(block: Builder.() -> Builder): PaymentRequest {
            return this.block().build()
        }

        fun clientIp(ip: String?): Builder = apply { this.clientIp = ip }

        fun transfers(transfers: List<Transfer>?): Builder = apply { this.transfers = transfers }

        fun transfers(vararg transfers: Transfer): Builder = transfers(transfers.toList())

        fun capture(capture: Boolean?): Builder = apply { this.capture = capture }

        fun metadata(data: Metadata?): Builder = apply { this.metaData = data }

        fun merchantCustomerId(id: String?): Builder = apply { this.merchantCustomerId = id }

        fun paymentMethodData(data: PaymentMethodData): Builder = apply { paymentMethodData = data }

        fun airline(airline: Airline?): Builder = apply { this.airline = airline }

        fun deal(deal: Deal?): Builder = apply { this.deal = deal }

        fun build(): PaymentRequest {
            when (amount) {
                //  NULL_AMOUNT -> throw PaymentNotInitializedException("Amount for payment is not defined!")
                else -> {/* do nothing */}
            }
            return PaymentRequest(this)
        }

        private companion object {
            private val NULL_AMOUNT: Amount = Amount("null", "null")
            private val NULL_PAYMENT: PaymentRequest = PaymentRequest(
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


}

data class Recipient(val gatewayId: String)

data class Airline(
    val ticketNumber: String? = null,
    val bookingReference: String? = null,
    val passengers: List<Passenger>? = null,
    val legs: List<Leg>? = null
) {

    private constructor(builder: Builder) : this(
        ticketNumber = builder.ticketNumber,
        bookingReference = builder.bookingReference,
        passengers = builder.passengers,
        legs = builder.legs
    )

    class Builder {
        internal var ticketNumber: String? = null
            private set
        internal var bookingReference: String? = null
            private set
        internal var passengers: List<Passenger>? = null
            private set
        internal var legs: List<Leg>? = null
            private set

        fun ticketNumber(number: String?): Builder = apply { ticketNumber = number }

        fun bookingReference(reference: String?): Builder = apply { bookingReference = reference }

        fun passengers(vararg passengers: Passenger): Builder = passengers(passengers.toList())

        fun passengers(passengers: List<Passenger>?): Builder = apply { this.passengers = passengers }

        fun legs(legs: List<Leg>?): Builder = apply { this.legs = legs }

        fun legs(vararg legs: Leg): Builder = legs(legs.toList())

        fun build(): Airline = Airline(this)
    }
}

data class Leg(
    val departureAirport: String,
    val destinationAirport: String,
    val departureDate: String,
    val carriedCode: String? = null
)

data class Passenger(
    val firstname: String, val lastname: String
)

data class Card(
    val number: String,
    val expiryYeah: String,
    val expiryMonth: String,
    val csc: String? = null,
    val cardholder: String? = null
)

sealed class Confirmation(val type: String) {

    data class Embedded(val locale: String? = null) : Confirmation(EMBEDDED)

    data class External(val locale: String? = null) : Confirmation(EXTERNAL)

    data class MobileApplication(
        val returnUrl: String, val locale: String? = null
    ) : Confirmation(MOBILE_APPLICATION)

    data class QRCode(val locale: String? = null) : Confirmation(QR_CODE)

    data class Redirect(
        val returnUrl: String, val locale: String? = null, val enforce: Boolean? = null
    ) : Confirmation(REDIRECT)


    companion object {
        // Confirmation types
        const val EMBEDDED: String = "embedded"
        const val EXTERNAL: String = "external"
        const val MOBILE_APPLICATION: String = "mobile_application"
        const val QR_CODE: String = "qr"
        const val REDIRECT: String = "redirect"

    }
}

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
