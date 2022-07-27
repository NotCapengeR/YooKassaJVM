package yookassa.exceptions

open class PaymentException(message: String? = null) : RuntimeException(message)

open class PaymentInitializeException(message: String? = null) : PaymentException(message)

open class PaymentNotInitializedException(message: String? = null) : PaymentInitializeException(message)