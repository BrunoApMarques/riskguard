package com.riskguard.riskguard.service;

import com.riskguard.riskguard.domain.Alert;
import com.riskguard.riskguard.repo.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    private final AlertRepository repo;

    public AlertService(AlertRepository repo) { this.repo = repo; }

    public List<Alert> listAll() { return repo.findAll(); }
}
