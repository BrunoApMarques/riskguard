package com.riskguard.riskguard.api;

import com.riskguard.riskguard.api.dto.TradeRequest;
import com.riskguard.riskguard.domain.Trade;
import com.riskguard.riskguard.service.TradeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trades")
public class TradeController {
    private final TradeService tradeService;
    public TradeController(TradeService tradeService) { this.tradeService = tradeService; }

    @PostMapping
    public ResponseEntity<Trade> create(@RequestBody @Valid TradeRequest req) {
        Trade t = tradeService.enqueueTrade(req);
        return ResponseEntity.accepted().body(t); // 202 Accepted (processamento assíncrono)
    }
}
