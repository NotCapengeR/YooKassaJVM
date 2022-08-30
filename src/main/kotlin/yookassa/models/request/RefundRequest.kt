package yookassa.models.request

import yookassa.models.shared.Amount
import yookassa.models.shared.Currencies
import yookassa.models.shared.refunds.Deal
import yookassa.models.shared.refunds.RefundSettlement
import yookassa.models.shared.refunds.Source
import yookassa.utils.toAmount

data class RefundRequest(
    val paymentId: String,
    val amount: Amount,
    val description: String? = null,
    val receipt: ReceiptRequest? = null,
    val sources: List<Source>? = null,
    val deal: Deal? = null,
): java.io.Serializable {

    private constructor(builder: Builder) : this(
        paymentId = builder.paymentId,
        amount = builder.amount,
        description = builder.description,
        receipt = builder.receipt,
        sources = builder.sources,
        deal = builder.deal
    )

    class Builder {
        internal lateinit var paymentId: String
        internal lateinit var amount: Amount
        internal var description: String? = null
        internal var receipt: ReceiptRequest? = null
        internal var sources: List<Source>? = null
        internal var deal: Deal? = null

        fun paymentId(value: String): Builder = apply { this.paymentId = value }

        fun amount(value: Double, currency: Currencies): Builder =
            amount(Amount(value.toAmount(), currency.name))

        fun amount(value: Amount): Builder = apply { this.amount = value }

        fun description(value: String?): Builder = apply { this.description = value }
        fun receipt(value: ReceiptRequest?): Builder = apply { this.receipt = value }
        fun sources(vararg value: Source): Builder = sources(value.toList())

        fun sources(value: List<Source>?): Builder = apply { this.sources = value }

        fun deal(vararg amount: Amount): Builder = deal(amount.toList())

        fun deal(amount: List<Amount>): Builder = apply {
            this.deal = Deal(amount.map { RefundSettlement(amount = it) })
        }

        fun build() = RefundRequest(this)
    }
}