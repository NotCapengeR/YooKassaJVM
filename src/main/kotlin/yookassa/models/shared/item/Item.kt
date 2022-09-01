package yookassa.models.shared.item

import kotlinx.serialization.SerialName
import yookassa.YooKassaConfig
import yookassa.models.shared.Amount
import yookassa.models.shared.Currencies
import yookassa.utils.toAmount
import kotlinx.serialization.Serializable
import kotlin.properties.Delegates

@Serializable
data class Item(
    @SerialName("amount") val amount: Amount,
    @SerialName("description") val description: String,
    @SerialName("quantity") val quantity: Int,
    @SerialName("measure") val measure: String? = null,
    @SerialName("mark_quantity") val markQuantity: MarkQuantity? = null,
    @SerialName("vat_code") val vatCode: Int,
    @SerialName("payment_subject") val paymentSubject: String? = null,
    @SerialName("payment_mode") val paymentMode: String? = null,
    @SerialName("country_of_origin_code") val countyOfOriginMode: String? = null,
    @SerialName("customs_declaration_number") val customerDeclarationNumber: String? = null,
    @SerialName("excise") val excise: String? = null,
    @SerialName("product_code") val productCode: String? = null,
    @SerialName("mark_code_info") val markCodeInfo: MarkCodeInfo? = null,
    @SerialName("mark_mode") val markMode: String? = null,
    @SerialName("payment_subject_industry_details") val paymentSubjectIndustryDetails: List<PaymentSubjectIndustryDetails>? = null
): java.io.Serializable {

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
        internal lateinit var amount: Amount
        internal lateinit var description: String
        internal var quantity by Delegates.notNull<Int>()
        internal var vatCode by Delegates.notNull<Int>()
        internal var measure: String? = null
        internal var markQuantity: MarkQuantity? = null
        internal var paymentSubject: String? = null
        internal var paymentMode: String? = null
        internal var countyOfOriginMode: String? = null
        internal var customerDeclarationNumber: String? = null
        internal var excise: String? = null
        internal var productCode: String? = null
        internal var markCodeInfo: MarkCodeInfo? = null
        internal var markMode: String? = null
        internal var paymentSubjectIndustryDetails: List<PaymentSubjectIndustryDetails>? = null

        @JvmOverloads
        fun amount(value: Double, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Builder =
            amount(Amount(value.toAmount(), currency.name))

        fun amount(amount: Amount): Builder =
            apply { this.amount = amount }

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
        fun paymentSubjectIndustryDetails(vararg details: PaymentSubjectIndustryDetails): Builder =
            apply { this.paymentSubjectIndustryDetails = details.toList() }

        fun paymentSubjectIndustryDetails(details: List<PaymentSubjectIndustryDetails>?): Builder =
            apply { this.paymentSubjectIndustryDetails = details }

        fun build(): Item = Item(this)
    }
}

@Serializable
data class MarkQuantity(
    @SerialName("numerator") val numerator: Int,
    @SerialName("denominator") val denominator: Int
    ): java.io.Serializable

@Serializable
data class MarkCodeInfo(
    @SerialName("mark_code_raw") val markCodeRaw: String? = null,
    @SerialName("unknown") val unknown: String? = null,
    @SerialName("ean_8") val ean8: String? = null,
    @SerialName("ean_13") val ean13: String? = null,
    @SerialName("itf_14") val itf14: String? = null,
    @SerialName("gs_10") val gs10: String? = null,
    @SerialName("gs_1m") val gs1m: String? = null,
    @SerialName("short") val short: String? = null,
    @SerialName("fur") val fur: String? = null,
    @SerialName("egais_20") val egais20: String? = null,
    @SerialName("egais_30") val egais30: String? = null
): java.io.Serializable {

    private constructor(builder: Builder) : this(
        markCodeRaw = builder.markCodeRaw,
        unknown = builder.unknown,
        ean8 = builder.ean8,
        ean13 = builder.ean13,
        gs10 = builder.gs10,
        gs1m = builder.gs1m,
        fur = builder.fur,
        short = builder.short,
        egais20 = builder.egais20,
        egais30 = builder.egais30
    )

    class Builder {
        internal var markCodeRaw: String? = null
        internal var unknown: String? = null
        internal var ean8: String? = null
        internal var ean13: String? = null
        internal var gs10: String? = null
        internal var gs1m: String? = null
        internal var short: String? = null
        internal var fur: String? = null
        internal var egais20: String? = null
        internal var egais30: String? = null

        fun markCodeRav(markCodeRav: String?): Builder = apply { this.markCodeRaw = markCodeRav }

        fun unknown(unknown: String?): Builder = apply { this.unknown = unknown }

        fun ean8(ean8: String?): Builder = apply { this.ean8 = ean8 }

        fun ean13(ean13: String?): Builder = apply { this.ean13 = ean13 }

        fun gs10(gs10: String?): Builder = apply { this.gs10 = gs10 }

        fun gs1m(gs1m: String?): Builder = apply { this.gs1m = gs1m }

        fun short(short: String?): Builder = apply { this.short = short }

        fun fur(fur: String?): Builder = apply { this.fur = fur }

        fun egais20(egais20: String?): Builder = apply { this.egais20 = egais20 }

        fun egais30(egais30: String?): Builder = apply { this.egais30 = egais30 }

        fun build(): MarkCodeInfo = MarkCodeInfo(this)


    }
}

@Serializable
data class PaymentSubjectIndustryDetails(
    @SerialName("federal_id") val federalId: String,
    @SerialName("document_date") val documentDate: String,
    @SerialName("document_number") val documentNumber: String,
    @SerialName("value") val value: String
): java.io.Serializable
