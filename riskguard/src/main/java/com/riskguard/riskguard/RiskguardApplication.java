package com.riskguard.riskguard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RiskguardApplication {
	public static void main(String[] args) {
		SpringApplication.run(RiskguardApplication.class, args);
	}
}
