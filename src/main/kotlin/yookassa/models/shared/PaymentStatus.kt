package yookassa.models.shared

enum class PaymentStatus(val status: String) {
    PENDING("pending"),
    WAITING_FOR_CAPTURE("waiting_for_capture"),
    SUCCEEDED("succeeded"),
    CANCELED("canceled")
}