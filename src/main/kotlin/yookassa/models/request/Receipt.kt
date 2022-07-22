package yookassa.models.request

import yookassa.models.item.Item

data class Receipt(
    val items: List<Item>,
    val customer: Customer? = null,
    val phone: String? = null,
    val email: String? = null,
    val taxSystemCode: Int? = null,
    val recipientIndustryDetails: List<ReceiptIndustryDetails>? = null,
    val recipientOperationalDetails: RecipientOperationalDetails? = null
) {

    data class Customer(
        val fullName: String? = null,
        val inn: Int? = null,
        val email: String? = null,
        val phone: String? = null
    )


    data class ReceiptIndustryDetails(
        val federalId: String,
        val documentDate: String,
        val documentNumber: String,
        val value: String
    )

    data class RecipientOperationalDetails(
        val operationId: Int,
        val value: String,
        val createdAt: String
    )




}