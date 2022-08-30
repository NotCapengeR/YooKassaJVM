package yookassa.models.shared

import yookassa.YooKassaConfig
import yookassa.utils.toAmount
import java.math.BigDecimal

sealed class VatData(val type: String): java.io.Serializable {

    object Untaxed : VatData(UNTAXED)

    data class Calculated(val amount: Amount, val rate: String) : VatData(CALCULATED)

    data class Mixed(val amount: Amount) : VatData(MIXED)

    companion object {
        const val UNTAXED: String = "untaxed"
        const val CALCULATED: String = "calculated"
        const val MIXED: String = "mixed"
    }
}

data class Transfer(
    val accountId: String,
    val amount: Amount,
    val platformFeeAmount: Amount? = null,
    val description: String? = null,
    val metaData: Metadata? = null
): java.io.Serializable {

    private constructor(builder: Builder) : this(
        accountId = builder.accountId,
        amount = builder.amount,
        platformFeeAmount = builder.platformFeeAmount,
        description = builder.description,
        metaData = builder.metaData
    )

    class Builder {
        internal lateinit var accountId: String
            private set
        internal lateinit var amount: Amount
            private set
        internal var platformFeeAmount: Amount? = null
            private set
        internal var description: String? = null
            private set
        internal var metaData: Metadata? = null
            private set

        fun build(): Transfer = Transfer(this)

        fun accountId(id: String): Builder = apply { this.accountId = id }

        fun setAmount(amount: Amount): Builder = apply { this.amount = amount }

        fun metadata(data: Metadata): Builder = apply { metaData = data }

        fun description(description: String?): Builder = apply { this.description = description }

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

        fun platformFeeAmount(amount: Amount): Builder = apply { this.platformFeeAmount = amount }

        @JvmOverloads
        fun platformFeeAmount(value: Double, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun platformFeeAmount(value: Float, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun platformFeeAmount(value: Int, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun platformFeeAmount(value: Long, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun platformFeeAmount(value: Short, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun platformFeeAmount(value: Byte, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        fun platformFeeAmount(value: UByte, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        fun platformFeeAmount(value: UInt, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        fun platformFeeAmount(value: UShort, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        fun platformFeeAmount(value: ULong, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))

        @JvmOverloads
        fun platformFeeAmount(value: BigDecimal, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            platformFeeAmount(Amount(value.toAmount(), currency.name))
    }
}

data class CancellationDetails(
    val party: String,
    val reason: String,
): java.io.Serializable

data class Deal(
    val id: String,
    val settlements: List<Settlement>
): java.io.Serializable

data class Settlement(
    val type: String,
    val amount: Amount,
) : java.io.Serializable

typealias Metadata = Map<String, String>