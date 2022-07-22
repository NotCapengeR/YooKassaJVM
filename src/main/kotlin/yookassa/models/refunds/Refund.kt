package yookassa.models.refunds

import yookassa.models.Amount
import yookassa.models.Currencie
import yookassa.models.Receipt
import yookassa.models.toAmount

data class Refund(
    val paymentId: String,
    val amount: Amount,
    val description: String? = null,
    val receipt: Receipt? = null,
    val sources: List<Source>? = null,
    val deal: Deal? = null,
) {

    private constructor(builder: Builder) : this(
        paymentId = builder.paymentId,
        amount = builder.amount,
        description = builder.description,
        receipt = builder.receipt,
        sources = builder.sources,
        deal = builder.deal
    )

    class Builder {
        lateinit var paymentId: String
        lateinit var amount: Amount
        var description: String? = null
        var receipt: Receipt? = null
        var sources: List<Source>? = null
        var deal: Deal? = null

        fun paymentId(value: String): Builder = apply { this.paymentId = value }
        fun amount(value: Double, currency: Currencie): Builder =
            apply { this.amount = Amount(value.toAmount(), currency.name) }

        fun description(value: String): Builder = apply { this.description = value}
        fun receipt(value: Receipt): Builder = apply { this.receipt = value }
        fun sources(vararg value: Source): Builder = apply { this.sources = value.toList() }
        fun deal(vararg settlement: RefundSettlement): Builder = apply { this.deal = Deal(settlement.toList()) }
        fun build() = Refund(this)
    }
}

data class Source(
    val accountId: String,
    val amount: Amount,
    val platformFeeAmount: Amount? = null,
)

data class Deal(
    val refundSettlements: List<RefundSettlement>
)

data class RefundSettlement(
    val type: String = "payout",
    val amount: Amount
)