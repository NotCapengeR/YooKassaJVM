package yookassa.models.item

import yookassa.models.Amount
import yookassa.models.Currencies
import yookassa.models.Receipt
import yookassa.models.toAmount
import kotlin.properties.Delegates

data class Item(
    val amount: Amount,
    val description: String,
    val quantity: Int,
    val vatCode: Int,
    val measure: String? = null,
    val markQuantity: Receipt.MarkQuantity? = null,
    val paymentSubject: String? = null,
    val paymentMode: String? = null,
    val countyOfOriginMode: String? = null,
    val customerDeclarationNumber: String? = null,
    val excise: String? = null,
    val productCode: String? = null,
    val markCodeInfo: Receipt.MarkCodeInfo? = null,
    val markMode: String? = null,
    val paymentSubjectIndustryDetails: List<Receipt.PaymentSubjectIndustryDetails>? = null
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
        countyOfOriginMode = builder.countyOfOriginMode,
        customerDeclarationNumber = builder.customerDeclarationNumber,
        excise = builder.excise,
        productCode = builder.productCode,
        markCodeInfo = builder.markCodeInfo,
        markMode = builder.markMode,
        paymentSubjectIndustryDetails = builder.paymentSubjectIndustryDetails,
    )
        class Builder {
            lateinit var amount: Amount
            lateinit var description: String
            var quantity by Delegates.notNull<Int>()
            var vatCode by Delegates.notNull<Int>()
            var measure: String? = null
            var markQuantity: Receipt.MarkQuantity? = null
            var paymentSubject: String? = null
            var paymentMode: String? = null
            var countyOfOriginMode: String? = null
            var customerDeclarationNumber: String? = null
            var excise: String? = null
            var productCode: String? = null
            var markCodeInfo: Receipt.MarkCodeInfo? = null
            var markMode: String? = null
            var paymentSubjectIndustryDetails: List<Receipt.PaymentSubjectIndustryDetails>? = null

            fun amount(value: Double, currency: Currencies): Builder =
                apply { this.amount = Amount(value.toAmount(), currency.name) }

            fun description(value: String): Builder = apply { this.description = value }
            fun quantity(value: Int): Builder = apply { this.quantity = value }
            fun vatCode(value: VatCode): Builder = apply { this.vatCode = value.ordinal }
            fun measure(value: Measure): Builder = apply { this.measure = value.value }
            fun markQuantity(numerator: Int, denominator: Int): Builder =
                apply {
                    if (this.measure != Measure.PIECE.name) throw RuntimeException("Measure type must be 'piece'")
                    if (numerator > denominator) throw RuntimeException("Numerator value can't exceed denominator value")
                    this.markQuantity = Receipt.MarkQuantity(numerator, denominator)
                }

            fun paymentSubject(value: PaymentSubject): Builder = apply { this.paymentSubject = value.value }
            fun paymentMode(value: PaymentMode): Builder = apply { this.paymentMode = value.value }
            fun countyOfOriginMode(value: CountryOfOriginMode): Builder = apply { this.countyOfOriginMode = value.name }
            fun customerDeclarationNumber(value: String): Builder = apply { this.customerDeclarationNumber = value }
            fun excise(value: String): Builder = apply { this.excise = value }
            fun productCode(value: String): Builder = apply { this.productCode = value }
            fun markCodeInfo(value: Receipt.MarkCodeInfo): Builder = apply { this.markCodeInfo = value }
            fun markMode(value: String): Builder = apply { this.markMode = value }
            fun paymentSubjectIndustryDetails(vararg details: Receipt.PaymentSubjectIndustryDetails): Builder =
                apply { this.paymentSubjectIndustryDetails = details.toList() }

            fun build() = Item(this)

        }







}
