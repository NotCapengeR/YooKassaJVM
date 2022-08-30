package yookassa.models.shared

enum class PaymentStatus(val status: String): java.io.Serializable {
    PENDING("pending"),
    WAITING_FOR_CAPTURE("waiting_for_capture"),
    SUCCEEDED("succeeded"),
    CANCELED("canceled")
}