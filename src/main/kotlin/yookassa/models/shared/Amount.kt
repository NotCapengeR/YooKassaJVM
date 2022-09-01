package yookassa.models.shared

import kotlinx.serialization.SerialName
import yookassa.YooKassaConfig
import yookassa.utils.toAmount
import java.math.BigDecimal
import kotlinx.serialization.Serializable
import java.math.BigInteger

@Serializable
data class Amount internal constructor(
    @SerialName("value") val value: String,
    @SerialName("currency") val currency: String
    ) : Comparable<Amount>, java.io.Serializable {

    constructor(pair: Pair<Double, Currencies>) : this(pair.first.toAmount(), pair.second.name)

    private val parsedValue: String
        get() = value.replace(',', '.').trim()

    operator fun unaryMinus(): Amount = fromValue(-parsedValue.toDouble(), Currencies.valueOf(this.currency))

    operator fun unaryPlus(): Amount = fromValue(+parsedValue.toDouble(), Currencies.valueOf(this.currency))

    operator fun not(): Boolean = !toBoolean()

    operator fun inc(): Amount = fromValue(parsedValue.toDouble().inc(), Currencies.valueOf(this.currency))

    operator fun dec(): Amount = fromValue(parsedValue.toDouble().dec(), Currencies.valueOf(this.currency))

    operator fun plus(other: Amount): Amount {
        if (!checkCurrency(other)) {
            throw IllegalArgumentException("Currencies in $this and $other must be equal!!!")
        }
        return fromValue(this.toBigDecimal() + other.toBigDecimal(), Currencies.valueOf(this.currency))
    }

    operator fun minus(other: Amount): Amount {
        if (!checkCurrency(other)) {
            throw IllegalArgumentException("Currencies in $this and $other must be equal!!!")
        }
        return fromValue(this.toBigDecimal() - other.toBigDecimal(), Currencies.valueOf(this.currency))
    }

    operator fun times(other: Amount): Amount {
        if (!checkCurrency(other)) {
            throw IllegalArgumentException("Currencies in $this and $other must be equal!!!")
        }
        return fromValue(this.toBigDecimal() * other.toBigDecimal(), Currencies.valueOf(this.currency))
    }

    operator fun div(other: Amount): Amount {
        if (!checkCurrency(other)) {
            throw IllegalArgumentException("Currencies in $this and $other must be equal!!!")
        }
        return fromValue(this.toBigDecimal() / other.toBigDecimal(), Currencies.valueOf(this.currency))
    }

    operator fun rem(other: Amount): Amount {
        if (!checkCurrency(other)) {
            throw IllegalArgumentException("Currencies in $this and $other must be equal!!!")
        }
        return fromValue(this.toBigDecimal() % other.toBigDecimal(), Currencies.valueOf(this.currency))
    }

    operator fun rangeTo(other: Amount): ClosedFloatingPointRange<Amount> {
        if (!checkCurrency(other)) {
            throw IllegalArgumentException("Currencies in $this and $other must be equal!!!")
        }
        return ClosedAmountRange(this, other)
    }

    override fun compareTo(other: Amount): Int {
        if (!checkCurrency(other)) {
            throw IllegalArgumentException("Currencies in $this and $other must be equal!!!")
        }
        return this.toDouble().compareTo(other.toDouble())
    }


    fun toBoolean(): Boolean = parsedValue.toDouble() != 0.0

    fun toDouble(): Double = parsedValue.toDouble()
    fun toDoubleOrNull(): Double? = parsedValue.toDoubleOrNull()

    fun toFloat(): Float = parsedValue.toFloat()
    fun toFloatOrNull(): Float? = parsedValue.toFloatOrNull()


    fun toInt(): Int = parsedValue.dropLast(3).toInt()
    fun toIntOrNull(): Int? = parsedValue.dropLast(3).toIntOrNull()


    fun toLong(): Long = parsedValue.dropLast(3).toLong()
    fun toLongOrNull(): Long? = parsedValue.dropLast(3).toLongOrNull()

    fun toShort(): Short = parsedValue.dropLast(3).toShort()
    fun toShortOrNull(): Short? = parsedValue.dropLast(3).toShortOrNull()

    fun toByte(): Byte = parsedValue.dropLast(3).toByte()
    fun toByteOrNull(): Byte? = parsedValue.dropLast(3).toByteOrNull()

    fun toBigInteger(): BigInteger = BigInteger(parsedValue)
    fun toBigIntegerOrNull(): BigInteger? {
        return try {
            toBigInteger()
        } catch (ex: NumberFormatException) {
            null
        }
    }


    fun toBigDecimal(): BigDecimal = BigDecimal(parsedValue)
    fun toBigDecimalOrNull(): BigDecimal? {
        return try {
            toBigDecimal()
        } catch (ex: NumberFormatException) {
            null
        }
    }

    fun isNegative(): Boolean = toDouble() < 0.0

    fun isPositive(): Boolean = toDouble() >= 0.0

    private fun checkCurrency(other: Amount): Boolean {
        return this.currency == other.currency
    }

    companion object {
        @JvmStatic
        @JvmOverloads
        fun fromValue(value: Double, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Amount {
            return Amount(value.toAmount(), currency.name)
        }

        @JvmStatic
        @JvmOverloads
        fun fromValue(value: Float, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Amount {
            return Amount(value.toAmount(), currency.name)
        }

        @JvmStatic
        @JvmOverloads
        fun fromValue(value: Int, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Amount {
            return Amount(value.toAmount(), currency.name)
        }

        @JvmStatic
        @JvmOverloads
        fun fromValue(value: Long, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Amount {
            return Amount(value.toAmount(), currency.name)
        }

        @JvmStatic
        @JvmOverloads
        fun fromValue(value: Short, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Amount {
            return Amount(value.toAmount(), currency.name)
        }

        @JvmStatic
        @JvmOverloads
        fun fromValue(value: Byte, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Amount {
            return Amount(value.toAmount(), currency.name)
        }

        @JvmStatic
        @JvmOverloads
        fun fromValue(value: BigDecimal, currency: Currencies = YooKassaConfig.DEFAULT_CURRENCY): Amount {
            return Amount(value.toAmount(), currency.name)
        }
    }

    private class ClosedAmountRange(
        start: Amount,
        endInclusive: Amount
    ) : ClosedFloatingPointRange<Amount> {
        private val _start = start
        private val _endInclusive = endInclusive
        override val start: Amount get() = _start
        override val endInclusive: Amount get() = _endInclusive

        override fun lessThanOrEquals(a: Amount, b: Amount): Boolean = a <= b

        override fun contains(value: Amount): Boolean = value >= _start && value <= _endInclusive
        override fun isEmpty(): Boolean = _start > _endInclusive

        override fun equals(other: Any?): Boolean {
            return other is ClosedAmountRange && (isEmpty() && other.isEmpty() ||
                    _start == other._start && _endInclusive == other._endInclusive)
        }

        override fun hashCode(): Int {
            return if (isEmpty()) -1 else 31 * _start.hashCode() + _endInclusive.hashCode()
        }

        override fun toString(): String = "${_start.toDouble()}..${_endInclusive.toDouble()}"
    }

}

