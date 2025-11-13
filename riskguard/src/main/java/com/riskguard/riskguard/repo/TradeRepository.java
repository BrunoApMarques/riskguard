package com.riskguard.riskguard.repo;

import com.riskguard.riskguard.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TradeRepository extends JpaRepository<Trade, UUID> { }
