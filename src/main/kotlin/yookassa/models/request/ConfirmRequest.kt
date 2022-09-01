package yookassa.models.request

import kotlinx.serialization.SerialName
import yookassa.YooKassaConfig
import yookassa.models.shared.Amount
import yookassa.models.shared.Currencies
import yookassa.models.shared.refunds.RefundDeal
import yookassa.utils.toAmount
import kotlinx.serialization.Serializable
import yookassa.models.shared.receipt.Receipt
import java.math.BigDecimal

@Serializable
data class ConfirmRequest(
    val amount: Amount,
    val receipt: Receipt? = null,
    val airline: Airline? = null,
    val transfers: List<ConfirmTransfer>? = null,
    val deal: RefundDeal? = null
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
        internal var receipt: Receipt? = null
            private set
        internal var airline: Airline? = null
            private set
        internal var transfers: List<ConfirmTransfer>? = null
            private set
        internal var deal: RefundDeal? = null
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

        fun receipt(receipt: Receipt?): Builder = apply { this.receipt = receipt }

        fun airline(airline: Airline?): Builder = apply { this.airline = airline }

        fun transfers(transfers: List<ConfirmTransfer>?): Builder = apply { this.transfers = transfers }

        fun transfers(vararg transfers: ConfirmTransfer): Builder = transfers(transfers.toList())

        fun dead(deal: RefundDeal?): Builder = apply { this.deal = deal }

        fun build(): ConfirmRequest = ConfirmRequest(this)
    }
}

@Serializable
data class ConfirmTransfer @JvmOverloads constructor(
    @SerialName("account_id") val accountId: String,
    @SerialName("amount") val amount: Amount,
    @SerialName("platform_fee_amount") val platformFeeAmount: Amount? = null
): java.io.Serializable