package com.riskguard.riskguard.rules;

import com.riskguard.riskguard.domain.Trade;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MaxNotionalPerTradeRule implements RiskRule {
    private static final BigDecimal MAX_NOTIONAL = new BigDecimal("1000000"); // 1M

    @Override public String name() { return "MaxNotionalPerTradeRule"; }
    @Override public String description() { return "Limita notional (qty*price) por trade (1M)"; }

    @Override
    public RuleResult evaluate(Trade trade) {
        BigDecimal notional = trade.getPrice().multiply(BigDecimal.valueOf(trade.getQuantity()));
        if (notional.compareTo(MAX_NOTIONAL) > 0) {
            return RuleResult.violation(name(), "Notional acima do limite: " + notional);
        }
        return RuleResult.ok(name());
    }
}
