package com.riskguard.riskguard.domain;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "trades")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Trade {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String clientId;

    @Column(nullable = false)
    private String asset;

    @Column(nullable = false)
    private long quantity;

    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal price;

    @Column(nullable = false)
    private Instant createdAt;
}
