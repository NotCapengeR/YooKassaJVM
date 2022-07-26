package yookassa.models.shared.item

import kotlinx.serialization.Serializable

@Serializable
enum class PaymentSubject(val value: String) : java.io.Serializable {
    COMMODITY("commodity"),
    EXCISE("excise"),
    JOB("job"),
    SERVICE("service"),
    PAYMENT("payment"),
    CASINO("casino"),
    GAMBLING_BET("gambling_bet"),
    GAMBLING_PRIZE("gambling_prize"),
    LOTTERY("lottery"),
    LOTTERY_PRIZE("lottery_prize"),
    INTELLECTUAL_ACTIVITY("intellectual_activity"),
    AGENT_COMMISSION("agent_commission"),
    PROPERTY_RIGHT("property_right"),
    NON_OPERATING_GAIN("non_operating_gain"),
    INSURANCE_PREMIUM("insurance_premium"),
    SALES_TAX("sales_tax"),
    RESORT_FEE("resort_fee"),
    COMPOSITE("composite"),
    ANOTHER("another"),
    MARKED("marked"),
    NON_MARKED("non_marked"),
    MARKED_EXCISE("marked_excise"),
    NON_MARKED_EXCISE("non_marked_excise"),
    FINE("fine"),
    TAX("tax"),
    LIEN("lien"),
    COST("cost"),
    AGENT_WITHDRAWALS("agent_withdrawals"),
    PENSION_INSURANCE_WITHOUT_PAYOUTS("pension_insurance_without_payouts"),
    PENSION_INSURANCE_WITH_PAYOUTS("pension_insurance_with_payouts"),
    HEALTH_INSURANCE_WITHOUT_PAYOUTS("health_insurance_without_payouts"),
    HEALTH_INSURANCE_WITH_PAYOUTS("health_insurance_with_payouts"),
    HEALTH_INSURANCE("health_insurance")
}

