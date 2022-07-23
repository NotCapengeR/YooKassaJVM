package yookassa.models.shared

enum class TaxSystemCode(val code: Int) {
    NoVAT(1), VATat0(2), VATat10(3), VATIsWaitingForItems20(4),
    VATCheckAtTheEstimatedRate10110(5), VATCheckAtTheEstimatedRate20120(6),
}