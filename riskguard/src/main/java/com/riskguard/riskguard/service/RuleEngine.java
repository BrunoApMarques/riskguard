package com.riskguard.riskguard.service;

import com.riskguard.riskguard.domain.Trade;
import com.riskguard.riskguard.rules.RiskRule;
import com.riskguard.riskguard.rules.RuleResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleEngine {
    private final List<RiskRule> rules;

    public RuleEngine(List<RiskRule> rules) {
        this.rules = rules;
    }

    public List<RuleResult> evaluate(Trade trade) {
        List<RuleResult> results = new ArrayList<>();
        for (RiskRule r : rules) {
            RuleResult res = r.evaluate(trade);
            if (res.violated()) results.add(res);
        }
        return results;
    }

    public List<String> listRuleSummaries() {
        return rules.stream().map(r -> r.name() + " - " + r.description()).toList();
    }
}
