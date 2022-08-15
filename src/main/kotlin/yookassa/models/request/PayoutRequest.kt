package yookassa.models.request

import yookassa.models.response.PayoutCard
import yookassa.models.response.PayoutDeal
import yookassa.models.response.SelfEmployed
import yookassa.models.shared.Amount
import yookassa.models.shared.Metadata

data class PayoutRequest(
    val amount: Amount,
    val payoutDestinationData: PayoutDestinationData? = null,
    val payoutToken: String? = null,
    val paymentMethodId: String? = null,
    val description: String? = null,
    val deal: PayoutDeal? = null,
    val selfEmployed: SelfEmployed? = null,
    val receiptData: ReceiptData? = null,
    val personalData: List<PersonalData>? = null,
    val metadata: Metadata? = null,
) {
}

sealed class PayoutDestinationData(val type: String) {

    data class BankCard(
        val card: PayoutCard
    ): PayoutDestinationData(BANK_CARD)

    data class SBP(
        val bankId: String,
        val phone: String,
    ) : PayoutDestinationData(SBP)

    data class YooMoney(
        val accountNumber: String,
    ) : PayoutDestinationData(YOO_MONEY)

    companion object {
        const val BANK_CARD: String = "bank_card"
        const val SBP: String = "sbp"
        const val YOO_MONEY: String = "yoo_money"
    }
}

data class PersonalData(
    val id: String
)

data class ReceiptData(
    val serviceName: String,
    val amount: Amount? = null
)