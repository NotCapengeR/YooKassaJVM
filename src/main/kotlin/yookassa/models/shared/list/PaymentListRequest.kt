package yookassa.models.shared.list

import yookassa.models.response.PaymentMethod
import yookassa.models.shared.PaymentStatus
import kotlinx.serialization.Serializable

@Serializable
data class PaymentListRequest(
    val limit: Int = 10,
    val createdAtGte: String? = null,
    val createdAtGt: String? = null,
    val createdAtLte: String? = null,
    val createdAtLt: String? = null,
    val capturedAtGte: String? = null,
    val capturedAtGt: String? = null,
    val capturedAtLte: String? = null,
    val capturedAtLt: String? = null,
    val paymentMethod: PaymentMethod? = null,
    val status: PaymentStatus? = null,
    val cursor: String? = null
): java.io.Serializable {

    private constructor(builder: Builder) : this(
        limit = builder.limit,
        createdAtGte = builder.createdAtGte,
        createdAtGt = builder.createdAtGt,
        createdAtLte = builder.createdAtLte,
        createdAtLt = builder.createdAtLt,
        capturedAtGte = builder.capturedAtGte,
        capturedAtGt = builder.capturedAtGt,
        capturedAtLte = builder.capturedAtLte,
        capturedAtLt = builder.capturedAtLt,
        paymentMethod = builder.paymentMethod,
        status = builder.status,
        cursor = builder.cursor
    )

    class Builder {
        internal var limit: Int = 10
        internal var createdAtGte: String? = null
        internal var createdAtGt: String? = null
        internal var createdAtLte: String? = null
        internal var createdAtLt: String? = null
        internal var capturedAtGte: String? = null
        internal var capturedAtGt: String? = null
        internal var capturedAtLte: String? = null
        internal var capturedAtLt: String? = null
        internal var paymentMethod: PaymentMethod? = null
        internal var status: PaymentStatus? = null
        internal var cursor: String? = null

        fun limit(value: Int): Builder {
            if (value < 1 || value > 100) {
               throw IllegalArgumentException("Limit must be between 1 and 100, but it actually: $value")
            }
            return apply { this.limit = value }
        }

        fun createdAtGte(value: String?): Builder = apply { this.createdAtGte = value }

        fun createdAtGt(value: String?): Builder = apply { this.createdAtGt = value }

        fun createdAtLte(value: String?): Builder = apply { this.createdAtLte = value }

        fun createdAtLt(value: String?): Builder = apply { this.createdAtLt = value }

        fun capturedAtGte(value: String?): Builder = apply { this.capturedAtGte = value }

        fun capturedAtGt(value: String?): Builder = apply { this.capturedAtGt = value }

        fun capturedAtLte(value: String?): Builder = apply { this.capturedAtLte = value }

        fun capturedAtLt(value: String?): Builder = apply { this.capturedAtLt = value }

        fun status(value: PaymentStatus?): Builder = apply { this.status = value }

        fun cursor(value: String?): Builder = apply { this.cursor = value }

        fun build(): PaymentListRequest = PaymentListRequest(this)

    }
}