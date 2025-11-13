package com.riskguard.riskguard.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "alerts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Alert {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID tradeId;

    @Column(nullable = false)
    private String ruleName;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private Instant createdAt;
}
