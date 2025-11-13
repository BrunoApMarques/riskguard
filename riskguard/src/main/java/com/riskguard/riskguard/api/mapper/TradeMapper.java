package com.riskguard.riskguard.api.mapper;

import com.riskguard.riskguard.api.dto.TradeRequest;
import com.riskguard.riskguard.domain.Trade;

import java.time.Instant;

public class TradeMapper {
    public static Trade toEntity(TradeRequest req) {
        return Trade.builder()
                .clientId(req.clientId())
                .asset(req.asset())
                .quantity(req.quantity())
                .price(req.price())
                .createdAt(Instant.now())
                .build();
    }
}
