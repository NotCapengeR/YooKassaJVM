package yookassa.models

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

    data class PaymentSubjectIndustryDetails(
        val federalId: String,
        val documentDate: String,
        val documentNumber: String,
        val value: String
    )

    data class MarkQuantity(val numerator: Int, val denominator: Int)

    data class MarkCodeInfo(
        val markCodeRaw: String? = null,
        val unknown: String? = null,
        val ean8: String? = null,
        val ean13: String? = null,
        val gs10: String? = null,
        val gs1m: String? = null,
        val short: String? = null,
        val fur: String? = null,
        val egais20: String? = null,
        val egais30: String? = null
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

    data class Item(
        val amount: Amount,
        val description: String,
        val quantity: Int,
        val vatCode: Int,
        val measure: String? = null,
        val markQuantity: MarkQuantity? = null,
        val paymentSubject: String? = null,
        val paymentMode: String? = null,
        val countyOfOriginMode: String? = null,
        val customerDeclarationNumber: String? = null,
        val excise: String? = null,
        val productCode: String? = null,
        val markCodeInfo: MarkCodeInfo? = null,
        val markMode: String? = null,
        val paymentSubjectIndustryDetails: List<PaymentSubjectIndustryDetails>? = null
    )
}