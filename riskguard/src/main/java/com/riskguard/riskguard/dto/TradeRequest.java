package com.riskguard.riskguard.api.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record TradeRequest(
        @NotBlank String clientId,
        @NotBlank String asset,
        @Positive long quantity,
        @DecimalMin(value = "0.01") BigDecimal price
) {}
