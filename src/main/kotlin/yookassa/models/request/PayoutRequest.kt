package yookassa.models.request

import kotlinx.serialization.SerialName
import yookassa.models.response.PayoutCard
import yookassa.models.response.PayoutDeal
import yookassa.models.response.SelfEmployed
import yookassa.models.shared.Amount
import yookassa.models.shared.Metadata
import kotlinx.serialization.Serializable
import yookassa.YooKassaConfig
import yookassa.models.shared.Currencies
import yookassa.utils.toAmount
import java.math.BigDecimal

@Serializable
data class PayoutRequest(
    val amount: Amount,
    val payoutDestinationData: PayoutDestinationData? = null,
    val payoutToken: String? = null,
    val paymentMethodId: String? = null,
    val description: String? = null,
    val deal: PayoutDeal? = null,
    val selfEmployed: SelfEmployed? = null,
    val receiptData: ReceiptData? = null,
    val personalData: List<PersonalData>? = null,
    val metadata: Metadata? = null,
) : java.io.Serializable {

    private constructor(builder: Builder) : this(
        amount = builder.amount,
        payoutDestinationData = builder.payoutDestinationData,
        payoutToken = builder.payoutToken,
        paymentMethodId = builder.paymentMethodId,
        deal = builder.deal,
        selfEmployed = builder.selfEmployed,
        receiptData = builder.receiptData,
        personalData = builder.personalData,
        metadata = builder.metadata
    )

    class Builder(
        internal var amount: Amount
    ) {
        internal var payoutDestinationData: PayoutDestinationData? = null
            private set
        internal var payoutToken: String? = null
            private set
        internal var paymentMethodId: String? = null
            private set
        internal var description: String? = null
            private set
        internal var deal: PayoutDeal? = null
            private set
        internal var selfEmployed: SelfEmployed? = null
            private set
        internal var receiptData: ReceiptData? = null
            private set
        internal var personalData: List<PersonalData>? = null
            private set
        internal var metadata: Metadata? = null
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

        fun payoutDestinationData(data: PayoutDestinationData?): Builder = apply { payoutDestinationData = data }

        fun payoutToken(token: String?): Builder = apply { payoutToken = token }

        fun paymentMethodId(id: String?): Builder = apply { paymentMethodId = id }

        fun description(value: String?): Builder = apply { description = value }

        fun deal(value: PayoutDeal?): Builder = apply { deal = value }

        fun deal(id: String): Builder = deal(PayoutDeal(id))

        fun selfEmployed(value: SelfEmployed?): Builder = apply { this.selfEmployed = value }

        fun selfEmployed(id: String): Builder = selfEmployed(SelfEmployed(id))

        fun receiptData(data: ReceiptData?): Builder = apply { receiptData = data }

        @JvmOverloads
        fun receiptData(serviceName: String, amount: Amount? = null): Builder =
            receiptData(ReceiptData(serviceName, amount))

        fun personalData(data: List<PersonalData>?): Builder = apply { personalData = data }
        fun personalData(vararg data: PersonalData): Builder = personalData(data.toList())

        fun metadata(data: Metadata): Builder = apply { metadata = data }

        fun build(): PayoutRequest = PayoutRequest(this)
    }
}

@Serializable
sealed class PayoutDestinationData : java.io.Serializable {

    @Serializable
    @SerialName(BANK_CARD)
    data class BankCard(
        val card: PayoutCard
    ) : PayoutDestinationData()

    @Serializable
    @SerialName(Companion.SBP)
    data class SBP(
        val bankId: String,
        val phone: String,
    ) : PayoutDestinationData()

    @Serializable
    @SerialName(YOO_MONEY)
    data class YooMoney(
        val accountNumber: String,
    ) : PayoutDestinationData()

    companion object {
        const val BANK_CARD: String = "bank_card"
        const val SBP: String = "sbp"
        const val YOO_MONEY: String = "yoo_money"
    }
}

@Serializable
data class PersonalData(
    val id: String
) : java.io.Serializable

@Serializable
data class ReceiptData(
    val serviceName: String,
    val amount: Amount? = null
) : java.io.Serializable