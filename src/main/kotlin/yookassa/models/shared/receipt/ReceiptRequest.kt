package yookassa.models.shared.receipt

import yookassa.models.shared.PaymentStatus

data class ReceiptRequest(
    val id: String,
    val type: String,
    val paymentId: String? = null,
    val refundId: String? = null,
    val status: String,
    val fiscalDocumentNumber: String? = null,
    val fiscalStorageNumber: String? = null,
    val fiscalAttribute: String? = null,
    val fiscalProviderId: String? = null,
    val requestedAt: String? = null,
    val items: List<ReceiptItem>? = null
) {

    private constructor(builder: Builder) : this(
        id = builder.id,
        type = builder.type,
        paymentId = builder.paymentId,
        refundId = builder.refundId,
        status = builder.status.status,
        fiscalDocumentNumber = builder.fiscalDocumentNumber,
        fiscalStorageNumber = builder.fiscalStorageNumber,
        fiscalAttribute = builder.fiscalAttribute,
        fiscalProviderId = builder.fiscalProviderId,
        requestedAt = builder.requestedAt,
        items = builder.items
    )

    class Builder {
        internal lateinit var id: String
        internal lateinit var type: String
        internal var paymentId: String? = null
        internal var refundId: String? = null
        internal lateinit var status: PaymentStatus
        internal var fiscalDocumentNumber: String? = null
        internal var fiscalStorageNumber: String? = null
        internal var fiscalAttribute: String? = null
        internal var fiscalProviderId: String? = null
        internal var requestedAt: String? = null
        internal var items: List<ReceiptItem>? = null

        fun id(value: String): Builder = apply { this.id = value }

        fun type(value: ReceiptType): Builder = apply {
            this.type = value.type
        }

        fun paymentId(id: String?): Builder = apply { this.paymentId = id }

        fun refundId(id: String?): Builder = apply { this.refundId = id }

        fun status(value: PaymentStatus): Builder = apply {
            if (value == PaymentStatus.WAITING_FOR_CAPTURE) {
                throw IllegalArgumentException("Status couldn't be ${PaymentStatus.WAITING_FOR_CAPTURE.status} here")
            }
            this.status = value
        }

        fun fiscalDocumentNumber(value: String?): Builder = apply { this.fiscalDocumentNumber = value }

        fun fiscalStorageNumber(value: String?): Builder = apply { this.fiscalStorageNumber = value }

        fun fiscalAttribute(value: String?): Builder = apply { this.fiscalAttribute = value }

        fun fiscalProviderId(value: String?): Builder = apply { this.fiscalProviderId = value }

        fun requestedAt(value: String?): Builder = apply { this.requestedAt = value }

        fun items(items: List<ReceiptItem>?): Builder = apply { this.items = items }

        fun items(vararg items: ReceiptItem): Builder = items(items.toList())

        fun build(): ReceiptRequest = ReceiptRequest(this)
    }
}

enum class ReceiptType(val type: String) {
    Payment("payment"), Refund("refund")
}

