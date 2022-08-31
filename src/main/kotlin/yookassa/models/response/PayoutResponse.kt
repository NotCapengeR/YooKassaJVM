package yookassa.models.response

import kotlinx.serialization.SerialName
import yookassa.models.shared.Amount
import yookassa.models.shared.CancellationDetails
import yookassa.models.shared.Metadata
import kotlinx.serialization.Serializable

@Serializable
data class PayoutResponse(
    val id: String,
    val amount: Amount,
    val status: String,
    val payoutDestination: PayoutDestination,
    val description: String? = null,
    val createdAt: String,
    val deal: PayoutDeal? = null,
    val selfEmployed: SelfEmployed? = null,
    val receipt: PayoutReceipt? = null,
    val cancellationDetails: CancellationDetails? = null,
    val metadata: Metadata? = null,
    val test: Boolean
)

@Serializable
sealed class PayoutDestination : java.io.Serializable {

    @Serializable
    @SerialName(BANK_CARD)
    data class BankCard(
        val card: PayoutCard
    ): PayoutDestination()

    @Serializable
    @SerialName(Companion.SBP)
    data class SBP(
        val bankId: String,
        val phone: String,
        val recipientChecked: Boolean
    ) : PayoutDestination()

    @Serializable
    @SerialName(YOO_MONEY)
    data class YooMoney(
        val accountNumber: String,
    ) : PayoutDestination()

    companion object {
        const val BANK_CARD: String = "bank_card"
        const val SBP: String = "sbp"
        const val YOO_MONEY: String = "yoo_money"
    }

}

@Serializable
data class PayoutCard(
    val BIN: String,
    val last4: String,
    val cardType: CardType,
    val issuerCountry: String? = null,
    val issuerName: String? = null
): java.io.Serializable

@Serializable
enum class CardType : java.io.Serializable {
    MasterCard, Visa, Mir, UnionPay, JCB, AmericanExpress, DinersClub, DiscoverCard, InstaPayment, InstaPaymentTM,
    Laser, Dankort, Solo, Switch, Unknown
}

@Serializable
data class PayoutDeal(val id: String): java.io.Serializable

@Serializable
data class SelfEmployed(val id: String): java.io.Serializable

@Serializable
data class PayoutReceipt(
    val serviceName: String,
    val npdReceiptId: String? = null,
    val url: String? = null,
    val amount: Amount? = null
): java.io.Serializable