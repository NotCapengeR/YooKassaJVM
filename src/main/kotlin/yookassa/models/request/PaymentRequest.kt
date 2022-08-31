package yookassa.models.request

import kotlinx.serialization.SerialName
import yookassa.YooKassaConfig
import yookassa.models.shared.*
import yookassa.utils.toAmount
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
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
): java.io.Serializable {

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
        constructor(
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

@Serializable
data class Recipient(val gatewayId: String): java.io.Serializable

@Serializable
data class Airline(
    val ticketNumber: String? = null,
    val bookingReference: String? = null,
    val passengers: List<Passenger>? = null,
    val legs: List<Leg>? = null
): java.io.Serializable {

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

@Serializable
data class Leg(
    val departureAirport: String,
    val destinationAirport: String,
    val departureDate: String,
    val carriedCode: String? = null
): java.io.Serializable

@Serializable
data class Passenger(
    val firstname: String, val lastname: String
): java.io.Serializable

@Serializable
data class Card(
    val number: String,
    val expiryYeah: String,
    val expiryMonth: String,
    val csc: String? = null,
    val cardholder: String? = null
): java.io.Serializable

@Serializable
sealed class Confirmation : java.io.Serializable {

    @Serializable
    @SerialName(EMBEDDED)
    data class Embedded(val locale: String? = null) : Confirmation()

    @Serializable
    @SerialName(EXTERNAL)
    data class External(val locale: String? = null) : Confirmation()

    @Serializable
    @SerialName(MOBILE_APPLICATION)
    data class MobileApplication(
        val returnUrl: String, val locale: String? = null
    ) : Confirmation()

    @Serializable
    @SerialName(QR_CODE)
    data class QRCode(val locale: String? = null) : Confirmation()

    @Serializable
    @SerialName(REDIRECT)
    data class Redirect(
        val returnUrl: String, val locale: String? = null, val enforce: Boolean? = null
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

@Serializable
sealed class PaymentMethodData : java.io.Serializable {

    @Serializable
    @SerialName(ALFA_CLICK)
    data class AlfaClick(val login: String? = null) : PaymentMethodData()

    @Serializable
    @SerialName(MOBILE_BALANCE)
    data class MobileBalance(val phone: String) : PaymentMethodData()

    @Serializable
    @SerialName(BANK_CARD)
    data class BankCard(val card: Card? = null) : PaymentMethodData()

    @Serializable
    @SerialName(INSTALLMENTS)
    object Installments : PaymentMethodData()

    @Serializable
    @SerialName(CASH)
    data class Cash(val phone: String? = null) : PaymentMethodData()

    @Serializable
    @SerialName(SBP_PAYMENT_TYPE)
    object SBP : PaymentMethodData()

    @Serializable
    @SerialName(SBERBANK_BUSINESS_ONLINE)
    data class SberBankBusinessOnline(val paymentPurpose: String, val vatData: VatData) :
        PaymentMethodData()

    @Serializable
    @SerialName(TINFOFF_BANK)
    object Tinkoff : PaymentMethodData()

    @Serializable
    @SerialName(YOO_MONEY)
    object YooMoney : PaymentMethodData()

    @Serializable
    @SerialName(QIWI_METHOD_DATA)
    data class QIWI(val phone: String? = null) : PaymentMethodData()

    @Serializable
    @SerialName(SBERPAY)
    data class SberPay(val phone: String? = null) : PaymentMethodData()

    companion object {
        //  Payment method data types
        const val ALFA_CLICK: String = "alfabank"
        const val MOBILE_BALANCE: String = "mobile_balance"
        const val BANK_CARD: String = "bank_card"
        const val INSTALLMENTS: String = "installments"
        const val CASH: String = "cash"
        const val SBP_PAYMENT_TYPE: String = "sbp"
        const val SBERBANK_BUSINESS_ONLINE: String = "b2b_sberbank"
        const val TINFOFF_BANK: String = "tinkoff_bank"
        const val YOO_MONEY: String = "yoo_money"
        const val QIWI_METHOD_DATA: String = "qiwi"
        const val SBERPAY: String = "sberbank"
    }

}
