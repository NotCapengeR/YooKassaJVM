package yookassa.models.request

import yookassa.YooKassaConfig
import yookassa.models.shared.Amount
import yookassa.models.shared.Currencies
import yookassa.models.shared.refunds.Deal
import yookassa.utils.toAmount
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class ConfirmRequest(
    val amount: Amount,
    val receipt: ReceiptRequest? = null,
    val airline: Airline? = null,
    val transfers: List<Transfer>? = null,
    val deal: Deal? = null
): java.io.Serializable {

    private constructor(builder: Builder) : this(
        amount = builder.amount,
        receipt = builder.receipt,
        airline = builder.airline,
        transfers = builder.transfers,
        deal = builder.deal
    )

    class Builder(
        internal val amount: Amount
    ) {
        internal var receipt: ReceiptRequest? = null
            private set
        internal var airline: Airline? = null
            private set
        internal var transfers: List<Transfer>? = null
            private set
        internal var deal: Deal? = null
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

        fun receipt(receipt: ReceiptRequest?): Builder = apply { this.receipt = receipt }

        fun airline(airline: Airline?): Builder = apply { this.airline = airline }

        fun transfers(transfers: List<Transfer>?): Builder = apply { this.transfers = transfers }

        fun transfers(vararg transfers: Transfer): Builder = transfers(transfers.toList())

        fun dead(deal: Deal?): Builder = apply { this.deal = deal }

        fun build(): ConfirmRequest = ConfirmRequest(this)
    }
}

@Serializable
data class Transfer @JvmOverloads constructor(
    val accountId: String,
    val amount: Amount,
    val platformFeeAmount: Amount? = null,
): java.io.Serializable