package com.riskguard.riskguard.rules;

import com.riskguard.riskguard.domain.Trade;
import org.springframework.stereotype.Component;

@Component
public class MaxQuantityPerTradeRule implements RiskRule {
    private static final long MAX_QTY = 100_000L;

    @Override public String name() { return "MaxQuantityPerTradeRule"; }
    @Override public String description() { return "Limita quantidade máxima por trade (100k)"; }

    @Override
    public RuleResult evaluate(Trade trade) {
        if (trade.getQuantity() > MAX_QTY) {
            return RuleResult.violation(name(), "Quantidade acima do limite: " + trade.getQuantity());
        }
        return RuleResult.ok(name());
    }
}
