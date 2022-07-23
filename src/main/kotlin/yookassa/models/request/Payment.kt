package yookassa.models.request

import yookassa.YooKassaConfig
import yookassa.models.shared.*
import yookassa.utils.toAmount
import java.math.BigDecimal

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

    class Builder {
        internal lateinit var amount: Amount
            private set
        internal var description: String? = null
            private set
        internal var receipt: Receipt? = null
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

        fun setAmount(amount: Amount): Builder = apply { this.amount = amount }

        @JvmOverloads
        fun setAmount(value: Double, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun setAmount(value: Float, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun setAmount(value: Int, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun setAmount(value: Long, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun setAmount(value: Short, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun setAmount(value: Byte, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        fun setAmount(value: UByte, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        fun setAmount(value: UInt, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        fun setAmount(value: UShort, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        fun setAmount(value: ULong, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun setAmount(value: BigDecimal, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            setAmount(Amount(value.toAmount(), currency.name))

        fun description(description: String?): Builder = apply { this.description = description }

        fun recipient(recipient: Recipient?): Builder = apply { this.recipient = recipient }

        fun recipient(gatewayId: String): Builder = recipient(Recipient(gatewayId))

        fun receipt(receipt: Receipt?): Builder = apply { this.receipt = receipt }

        fun confirmation(confirmation: Confirmation?): Builder = apply { this.confirmation = confirmation }

        fun create(block: Builder.() -> Unit): Payment = apply(block).build()

        fun clientIp(ip: String?): Builder = apply { this.clientIp = ip }

        fun transfers(transfers: List<Transfer>?): Builder = apply { this.transfers = transfers }

        fun transfers(vararg transfers: Transfer): Builder = transfers(transfers.toList())

        fun capture(capture: Boolean?): Builder = apply { this.capture = capture }

        fun metadata(data: Metadata?): Builder = apply { this.metaData = data }

        fun merchantCustomerId(id: String?): Builder = apply { this.merchantCustomerId = id }

        fun paymentMethodData(data: PaymentMethodData): Builder = apply { paymentMethodData = data }

        fun airline(airline: Airline?): Builder = apply { this.airline = airline }

        fun deal(deal: Deal?): Builder = apply { this.deal = deal }

        fun build(): Payment {
            when (amount) {
                //  NULL_AMOUNT -> throw PaymentNotInitializedException("Amount for payment is not defined!")
                else -> {/* do nothing */
                }
            }
            return Payment(this)
        }

        private companion object {
            private val NULL_AMOUNT: Amount = Amount("null", "null")
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

        fun passengers(passengers: List<Passenger>?): Builder = apply { this.passengers = passengers }

        fun legs(legs: List<Leg>?): Builder = apply { this.legs = legs }

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


    private companion object {
        // Confirmation types
        private const val EMBEDDED: String = "embedded"
        private const val EXTERNAL: String = "external"
        private const val MOBILE_APPLICATION: String = "mobile_application"
        private const val QR_CODE: String = "qr"
        private const val REDIRECT: String = "redirect"

    }
}
