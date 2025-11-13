package com.riskguard.riskguard.controller;

import com.riskguard.riskguard.domain.Alert;
import com.riskguard.riskguard.service.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
    private final AlertService service;
    public AlertController(AlertService service) { this.service = service; }

    @GetMapping
    public List<Alert> list() { return service.listAll(); }
}
