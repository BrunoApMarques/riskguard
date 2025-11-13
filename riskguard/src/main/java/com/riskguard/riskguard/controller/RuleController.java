package com.riskguard.riskguard.controller;

import com.riskguard.riskguard.service.RuleEngine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleController {
    private final RuleEngine engine;
    public RuleController(RuleEngine engine) { this.engine = engine; }

    @GetMapping
    public List<String> rules() { return engine.listRuleSummaries(); }
}
