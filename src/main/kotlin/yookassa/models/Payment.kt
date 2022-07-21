package yookassa.models

import yookassa.exceptions.PaymentNotInitializedException

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
        var amount: Amount = NULL_AMOUNT
            private set
        var description: String? = null
            private set
        var receipt: Receipt? = null
            private set
        var recipient: Recipient? = null
            private set
        var paymentToken: String? = null
            private set
        var paymentMethodId: String? = null
            private set
        var paymentMethodData: PaymentMethodData? = null
            private set
        var confirmation: Confirmation? = null
            private set
        var savePaymentMethod: Boolean? = null
            private set
        var capture: Boolean? = null
            private set
        var clientIp: String? = null
            private set
        var metaData: Metadata? = null
            private set
        var airline: Airline? = null
            private set
        var transfers: List<Transfer>? = null
            private set
        var deal: Deal? = null
            private set
        var merchantCustomerId: String? = null
            private set

        fun setAmount(amount: Amount): Builder = apply { this.amount = amount }

        fun setAmount(value: Double, currency: Currencies): Builder = setAmount(Amount(value.toAmount(), currency.name))

        fun description(description: String): Builder = apply { this.description = description }

        fun recipient(recipient: Recipient): Builder = apply { this.recipient = recipient }

        fun recipient(gatewayId: String): Builder = recipient(Recipient(gatewayId))

        fun receipt(receipt: Receipt?): Builder = apply { this.receipt = receipt }

        fun confirmation(confirmation: Confirmation?): Builder = apply { this.confirmation = confirmation }

        fun create(block: Builder.() -> Unit): Payment = apply(block).build()

        fun clientIp(ip: String): Builder = apply { this.clientIp = ip }

        fun capture(capture: Boolean): Builder = apply { this.capture = capture }

        fun metadata(data: Metadata): Builder = apply { this.metaData = data }

        fun merchantCustomerId(id: String): Builder = apply { this.merchantCustomerId = id }

        fun build(): Payment {
            when (amount) {
                NULL_AMOUNT -> throw PaymentNotInitializedException("Amount for payment is not defined!")
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
            val firstname: String, val lastname: String
        )
    }

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
}
