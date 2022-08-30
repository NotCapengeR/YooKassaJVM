package yookassa.models.shared.item

enum class PaymentMode(val value: String) : java.io.Serializable {
    FULL_PREPAYMENT("full_prepayment"),
    PARTIAL_PREPAYMENT("partial_prepayment"),
    ADVANCE("advance"),
    FULL_PAYMENT("full_payment"),
    PARTIAL_PAYMENT("partial_payment"),
    CREDIT("credit"),
    CREDIT_PAYMENT("credit_payment")
}