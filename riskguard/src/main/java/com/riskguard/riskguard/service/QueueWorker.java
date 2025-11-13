package com.riskguard.riskguard.service;

import com.riskguard.riskguard.domain.Alert;
import com.riskguard.riskguard.domain.Trade;
import com.riskguard.riskguard.repo.AlertRepository;
import com.riskguard.riskguard.rules.RiskRule;
import com.riskguard.riskguard.rules.RuleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Slf4j
@Component
public class QueueWorker {

    private final InMemoryQueue queue;
    private final RuleEngine ruleEngine;
    private final AlertRepository alertRepository;

    public QueueWorker(InMemoryQueue queue, RuleEngine ruleEngine, AlertRepository alertRepository) {
        this.queue = queue;
        this.ruleEngine = ruleEngine;
        this.alertRepository = alertRepository;
    }

    @Scheduled(fixedDelay = 200)
    public void process() {
        try {
            if (queue.size() == 0) return;
            Trade trade = queue.take();
            List<RuleResult> violations = ruleEngine.evaluate(trade);
            for (RuleResult v : violations) {
                Alert a = Alert.builder()
                        .tradeId(trade.getId())
                        .ruleName(v.ruleName())
                        .message(v.message())
                        .createdAt(Instant.now())
                        .build();
                alertRepository.save(a);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Worker interrompido");
        } catch (Exception e) {
            log.error("Erro processando trade", e);
        }
    }
}
