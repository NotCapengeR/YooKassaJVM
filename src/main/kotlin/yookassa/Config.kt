package yookassa

import yookassa.models.Currencies

object Config {
    var DEFAULT_CURRENCY: Currencies = Currencies.USD
        private set

    fun setDefaultCurrency(currency: Currencies)  {
        DEFAULT_CURRENCY = currency
    }

}