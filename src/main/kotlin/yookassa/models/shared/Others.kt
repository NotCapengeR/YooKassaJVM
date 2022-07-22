package yookassa.models.shared

data class Amount(val value: String, val currency: String)


sealed class VatData(val type: String) {

    object Untaxed : VatData(UNTAXED)

    data class Calculated(val amount: Amount, val rate: String) : VatData(CALCULATED)

    data class Mixed(val amount: Amount) : VatData(MIXED)

    private companion object {
        private const val UNTAXED: String = "untaxed"
        private const val CALCULATED: String = "calculated"
        private const val MIXED: String = "mixed"
    }
}

data class Transfer(
    val accountId: String,
    val amount: Amount,
    val platformFeeAmount: Amount? = null,
    val description: String? = null,
    val metaData: Metadata? = null
)

data class CancellationDetails(
    val party: String,
    val reason: String,
)

data class Deal(
    val id: String,
    val settlements: List<Settlement>
) {
    data class Settlement(
        val type: String,
        val amount: Amount,
    )
}

typealias Metadata = Map<String, String>