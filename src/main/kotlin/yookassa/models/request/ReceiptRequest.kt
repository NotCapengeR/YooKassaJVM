package yookassa.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import yookassa.models.shared.Settlement
import yookassa.models.shared.receipt.*

@Serializable
data class ReceiptRequest(
    @SerialName("type") val type: String,
    @SerialName("payment_id") val paymentId: String? = null,
    @SerialName("refund_id") val refundId: String? = null,
    @SerialName("customer") val customer: Customer? = null,
    @SerialName("items") val items: List<ReceiptItem>? = null,
    @SerialName("send") val send: Boolean,
    @SerialName("additional_user_props") val additionalUserProps: AdditionalUserProps? = null,
    @SerialName("receipt_industry_details") val receiptIndustryDetails: ReceiptIndustryDetails? = null,
    @SerialName("receipt_operational_details") val receiptOperationalDetails: ReceiptOperationalDetails? = null,
    @SerialName("settlements") val settlement: List<Settlement>,
    @SerialName("on_behalf_of") val onBehalfOn: String? = null,
) : java.io.Serializable {

    private constructor(builder: Builder) : this(
        type = builder.type.type,
        paymentId = builder.paymentId,
        refundId = builder.refundId,
        customer = builder.customer,
        items = builder.items,
        send = builder.send,
        additionalUserProps = builder.additionalUserProps,
        receiptIndustryDetails = builder.receiptIndustryDetails,
        receiptOperationalDetails = builder.receiptOperationalDetails,
        settlement = builder.settlement,
        onBehalfOn = builder.onBehalfOn
    )

    class Builder(
        internal var type: ReceiptType,
        internal var send: Boolean,
        internal var settlement: List<Settlement>
    ) {

        constructor(type: ReceiptType, send: Boolean, vararg settlement: Settlement) : this(
            type = type,
            send = send,
            settlement = settlement.toList()
        )

        internal var paymentId: String? = null
            private set
        internal var refundId: String? = null
            private set
        internal var customer: Customer? = null
            private set
        internal var items: List<ReceiptItem>? = null
            private set
        internal var additionalUserProps: AdditionalUserProps? = null
            private set
        internal var receiptIndustryDetails: ReceiptIndustryDetails? = null
            private set
        internal var receiptOperationalDetails: ReceiptOperationalDetails? = null
            private set
        internal var onBehalfOn: String? = null
            private set

        fun paymentId(id: String?): Builder = apply { paymentId = id }

        fun refundID(id: String?): Builder = apply { refundId = id }

        fun customer(value: Customer?): Builder = apply { customer = value }

        @JvmOverloads
        fun customer(
            fullName: String? = null,
            inn: Int? = null,
            email: String? = null,
            phone: String? = null
        ): Builder = customer(Customer(fullName, inn, email, phone))

        fun items(value: List<ReceiptItem>?): Builder = apply { items = value }

        fun items(vararg value: ReceiptItem): Builder = apply { items = value.toList() }

        fun additionalUserProps(props: AdditionalUserProps?): Builder = apply { additionalUserProps = props }

        fun additionalUserProps(name: String, value: String): Builder =
            additionalUserProps(AdditionalUserProps(name, value))

        fun receiptIndustryDetails(details: ReceiptIndustryDetails?): Builder = apply { receiptIndustryDetails = details }

        fun receiptIndustryDetails(
            federalId: String,
            documentDate: String,
            documentNumber: String,
            value: String
        ): Builder = receiptIndustryDetails(ReceiptIndustryDetails(federalId, documentDate, documentNumber, value))

        fun receiptOperationalDetails(details: ReceiptOperationalDetails?): Builder =
            apply { receiptOperationalDetails = details }

        fun receiptOperationalDetails(operationId: Int, value: String, createdAt: String): Builder =
            receiptOperationalDetails(ReceiptOperationalDetails(operationId, value, createdAt))

        fun onBehalfOn(value: String?): Builder = apply { onBehalfOn = value }

        fun build(): ReceiptRequest = ReceiptRequest(this)
    }
}

@Serializable
data class AdditionalUserProps(
    @SerialName("name") val name: String,
    @SerialName("value") val value: String
) : java.io.Serializable
