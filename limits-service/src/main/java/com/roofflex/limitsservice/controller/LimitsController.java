package com.roofflex.limitsservice.controller;

import com.roofflex.limitsservice.configuration.Configuration;
import com.roofflex.limitsservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.roofflex.limitsservice.model.Limits.limits;

@RestController
@RequestMapping("/api/v1")
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public ResponseEntity<Limits> getAllLimits() {
        return ResponseEntity.ok()
                .body(limits(configuration.getMinimum(), configuration.getMaximum()));
    }
}
