package com.riskguard.riskguard.rules;

public record RuleResult(boolean violated, String ruleName, String message) {
    public static RuleResult ok(String ruleName) {
        return new RuleResult(false, ruleName, null);
    }
    public static RuleResult violation(String ruleName, String message) {
        return new RuleResult(true, ruleName, message);
    }
}
