package youkassa.exceptions

internal open class PaymentException(message: String? = null) : RuntimeException(message)

internal open class PaymentInitializedException(message: String? = null) : PaymentException(message)

internal class PaymentNotInitializedException(message: String? = null) : PaymentInitializedException(message)

