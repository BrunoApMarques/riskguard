package com.riskguard.riskguard.service;

import com.riskguard.riskguard.api.dto.TradeRequest;
import com.riskguard.riskguard.api.mapper.TradeMapper;
import com.riskguard.riskguard.domain.Trade;
import com.riskguard.riskguard.repo.TradeRepository;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    private final TradeRepository tradeRepository;
    private final InMemoryQueue queue;

    public TradeService(TradeRepository tradeRepository, InMemoryQueue queue) {
        this.tradeRepository = tradeRepository;
        this.queue = queue;
    }

    public Trade enqueueTrade(TradeRequest req) {
        Trade t = TradeMapper.toEntity(req);
        t = tradeRepository.save(t); // gera id
        queue.enqueue(t);
        return t;
    }
}
