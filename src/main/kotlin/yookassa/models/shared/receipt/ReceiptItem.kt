package yookassa.models.shared.receipt

import yookassa.YooKassaConfig
import yookassa.models.shared.Amount
import yookassa.models.shared.Currencies
import yookassa.models.shared.item.*
import yookassa.utils.toAmount
import kotlin.properties.Delegates

data class ReceiptItem(
    val amount: Amount,
    val description: String,
    val quantity: Int,
    val vatCode: Int,
    val measure: String? = null,
    val markQuantity: MarkQuantity? = null,
    val paymentSubject: String? = null,
    val paymentMode: String? = null,
    val countyOfOriginMode: String? = null,
    val supplier: Supplier? = null,
    val customerDeclarationNumber: String? = null,
    val excise: String? = null,
    val agentType: String? = null,
    val productCode: String? = null,
    val markCodeInfo: MarkCodeInfo? = null,
    val markMode: String? = null,
    val paymentSubjectIndustryDetails: List<PaymentSubjectIndustryDetails>? = null
) {
    private constructor(builder: Builder) : this(
        amount = builder.amount,
        description = builder.description,
        quantity = builder.quantity,
        vatCode = builder.vatCode,
        measure = builder.measure,
        markQuantity = builder.markQuantity,
        paymentSubject = builder.paymentSubject,
        paymentMode = builder.paymentMode,
        agentType = builder.agentType,
        countyOfOriginMode = builder.countyOfOriginMode,
        supplier = builder.supplier,
        customerDeclarationNumber = builder.customerDeclarationNumber,
        excise = builder.excise,
        productCode = builder.productCode,
        markCodeInfo = builder.markCodeInfo,
        markMode = builder.markMode,
        paymentSubjectIndustryDetails = builder.paymentSubjectIndustryDetails,
    )

    class Builder {
        internal lateinit var amount: Amount
        internal lateinit var description: String
        internal var quantity by Delegates.notNull<Int>()
        internal var vatCode by Delegates.notNull<Int>()
        internal var measure: String? = null
        internal var markQuantity: MarkQuantity? = null
        internal var paymentSubject: String? = null
        internal var agentType: String? = null
        internal var paymentMode: String? = null
        internal var countyOfOriginMode: String? = null
        internal var customerDeclarationNumber: String? = null
        internal var excise: String? = null
        internal var supplier: Supplier? = null
        internal var productCode: String? = null
        internal var markCodeInfo: MarkCodeInfo? = null
        internal var markMode: String? = null
        internal var paymentSubjectIndustryDetails: List<PaymentSubjectIndustryDetails>? = null

        @JvmOverloads
        fun amount(value: Double, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            apply { this.amount = Amount(value.toAmount(), currency.name) }

        fun description(value: String): Builder = apply { this.description = value }
        fun quantity(value: Int): Builder = apply { this.quantity = value }
        fun vatCode(value: VatCode): Builder = apply { this.vatCode = value.ordinal }
        fun measure(value: Measure?): Builder = apply { this.measure = value?.value }
        fun markQuantity(numerator: Int, denominator: Int): Builder =
            apply {
                if (this.measure != Measure.PIECE.name)  {
                    throw IllegalArgumentException("Measure type must be 'piece'. Given type: ${this.measure}")
                }
                if (numerator > denominator) {
                    throw IllegalArgumentException("Numerator ($numerator) can't exceed denominator ($denominator)")
                }
                this.markQuantity = MarkQuantity(numerator, denominator)
            }

        fun markQuantity(markQuantity: MarkQuantity?): Builder = apply { this.markQuantity = markQuantity }

        fun paymentSubject(value: PaymentSubject?): Builder = apply { this.paymentSubject = value?.value }

        fun paymentMode(value: PaymentMode?): Builder = apply { this.paymentMode = value?.value }

        fun countyOfOriginMode(value: CountryOfOriginMode?): Builder = apply { this.countyOfOriginMode = value?.name }

        fun customerDeclarationNumber(value: String?): Builder = apply { this.customerDeclarationNumber = value }

        fun excise(value: String?): Builder = apply { this.excise = value }

        fun productCode(value: String?): Builder = apply { this.productCode = value }

        fun markCodeInfo(value: MarkCodeInfo?): Builder = apply { this.markCodeInfo = value }

        fun markMode(value: String?): Builder = apply { this.markMode = value }

        fun agentType(value: String?): Builder = apply { this.agentType = value }

        fun supplier(value: Supplier?): Builder = apply { this.supplier = value }

        @JvmOverloads
        fun supplier(name: String? = null, phone: String? = null, inn: String? = null): Builder = supplier(Supplier(name, phone, inn))

        fun paymentSubjectIndustryDetails(vararg details: PaymentSubjectIndustryDetails): Builder =
            apply { this.paymentSubjectIndustryDetails = details.toList() }

        fun paymentSubjectIndustryDetails(details: List<PaymentSubjectIndustryDetails>?): Builder =
            apply { this.paymentSubjectIndustryDetails = details }

        fun build(): ReceiptItem = ReceiptItem(this)
    }
}

data class Supplier(
    val name: String? = null,
    val phone: String? = null,
    val inn: String? = null
)