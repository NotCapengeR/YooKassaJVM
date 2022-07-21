package yookassa.exceptions

open class PaymentException(message: String? = null) : RuntimeException(message)

open class PaymentInitializedException(message: String? = null) : PaymentException(message)

class PaymentNotInitializedException(message: String? = null) : PaymentInitializedException(message)

