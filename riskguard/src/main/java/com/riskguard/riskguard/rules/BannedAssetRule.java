package com.riskguard.riskguard.rules;

import com.riskguard.riskguard.domain.Trade;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BannedAssetRule implements RiskRule {
    private final Set<String> banned = Set.of("MGLU3", "FRAUDE11");

    @Override public String name() { return "BannedAssetRule"; }
    @Override public String description() { return "Bloqueia ativos em lista proibida"; }

    @Override
    public RuleResult evaluate(Trade trade) {
        if (banned.contains(trade.getAsset().toUpperCase())) {
            return RuleResult.violation(name(), "Ativo proibido: " + trade.getAsset());
        }
        return RuleResult.ok(name());
    }
}
