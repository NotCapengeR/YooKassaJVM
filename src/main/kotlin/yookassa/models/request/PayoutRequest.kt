package yookassa.models.request

import kotlinx.serialization.SerialName
import yookassa.models.response.PayoutCard
import yookassa.models.response.PayoutDeal
import yookassa.models.response.SelfEmployed
import yookassa.models.shared.Amount
import yookassa.models.shared.Metadata
import kotlinx.serialization.Serializable

@Serializable
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
): java.io.Serializable

@Serializable
sealed class PayoutDestinationData: java.io.Serializable {

    @Serializable
    @SerialName(BANK_CARD)
    data class BankCard(
        val card: PayoutCard
    ): PayoutDestinationData()

    @Serializable
    @SerialName(Companion.SBP)
    data class SBP(
        val bankId: String,
        val phone: String,
    ) : PayoutDestinationData()

    @Serializable
    @SerialName(YOO_MONEY)
    data class YooMoney(
        val accountNumber: String,
    ) : PayoutDestinationData()

    companion object {
        const val BANK_CARD: String = "bank_card"
        const val SBP: String = "sbp"
        const val YOO_MONEY: String = "yoo_money"
    }
}

@Serializable
data class PersonalData(
    val id: String
): java.io.Serializable

@Serializable
data class ReceiptData(
    val serviceName: String,
    val amount: Amount? = null
): java.io.Serializable