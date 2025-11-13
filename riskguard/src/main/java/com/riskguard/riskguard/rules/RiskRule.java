package com.riskguard.riskguard.rules;

import com.riskguard.riskguard.domain.Trade;

public interface RiskRule {
    String name();
    String description();
    RuleResult evaluate(Trade trade);
}
