package yookassa.models.request

import yookassa.models.shared.TaxSystemCode
import yookassa.models.shared.item.Item
import kotlinx.serialization.Serializable

@Serializable
data class ReceiptRequest(
    val items: List<Item>,
    val customer: Customer? = null,
    val phone: String? = null,
    val email: String? = null,
    val taxSystemCode: Int? = null,
    val recipientIndustryDetails: List<ReceiptIndustryDetails>? = null,
    val recipientOperationalDetails: RecipientOperationalDetails? = null
): java.io.Serializable {

    private constructor(builder: Builder) : this(
        items = builder.items,
        customer = builder.customer,
        phone = builder.phone,
        email = builder.email,
        taxSystemCode = builder.taxSystemCode?.code,
        recipientIndustryDetails = builder.recipientIndustryDetails,
        recipientOperationalDetails = builder.recipientOperationalDetails
    )

    class Builder {
        lateinit var items: List<Item>
            private set
        var customer: Customer? = null
            private set
        var phone: String? = null
            private set
        var email: String? = null
            private set
        var taxSystemCode: TaxSystemCode? = null
            private set
        var recipientIndustryDetails: List<ReceiptIndustryDetails>? = null
            private set
        var recipientOperationalDetails: RecipientOperationalDetails? = null
            private set

        fun setItems(items: List<Item>): Builder = apply { this.items = items }

        fun setItems(vararg items: Item): Builder = setItems(items.toList())

        fun phone(phone: String?): Builder = apply { this.phone = phone }

        fun email(email: String?): Builder = apply { this.email = email }

        fun taxSystemCode(code: TaxSystemCode?): Builder = apply { this.taxSystemCode = code }

        fun customer(customer: Customer?): Builder = apply { this.customer = customer }

        @JvmOverloads
        fun customer(
            fullName: String? = null,
            inn: Int? = null,
            email: String? = null,
            phone: String? = null
        ): Builder =
            customer(
                Customer(
                    fullName,
                    inn,
                    email,
                    phone
                )
            )

        fun recipientIndustryDetails(details: List<ReceiptIndustryDetails>?): Builder = apply {
            this.recipientIndustryDetails = details
        }

        fun recipientIndustryDetails(vararg details: ReceiptIndustryDetails): Builder =
            recipientIndustryDetails(details.toList())

        fun recipientOperationalDetails(details: RecipientOperationalDetails): Builder = apply {
            this.recipientOperationalDetails = details
        }

        fun recipientOperationalDetails(
            operationId: Int,
            value: String,
            createdAt: String
        ): Builder = recipientOperationalDetails(RecipientOperationalDetails(operationId, value, createdAt))

        fun build(): ReceiptRequest = ReceiptRequest(this)
    }
}

@Serializable
data class Customer(
    val fullName: String? = null,
    val inn: Int? = null,
    val email: String? = null,
    val phone: String? = null
): java.io.Serializable {

    private constructor(builder: Builder) : this(
        fullName = builder.fullName,
        inn = builder.inn,
        email = builder.email,
        phone = builder.phone
    )
    class Builder {
        internal var fullName: String? = null
            private set
        internal var inn: Int? = null
            private set
        internal var email: String? = null
            private set
        internal var phone: String? = null
            private set

        fun fullName(name: String?): Builder = apply { fullName = name }

        fun inn(inn: Int?): Builder = apply { this.inn = inn }

        fun email(email: String?): Builder = apply { this.email = email }

        fun phone(number: String?): Builder = apply { this.phone = number }

        fun build(): Customer = Customer(this)
    }
}


@Serializable
data class ReceiptIndustryDetails(
    val federalId: String,
    val documentDate: String,
    val documentNumber: String,
    val value: String
)

@Serializable
data class RecipientOperationalDetails(
    val operationId: Int,
    val value: String,
    val createdAt: String
)
