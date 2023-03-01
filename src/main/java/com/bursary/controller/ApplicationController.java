package com.bursary.controller;

import com.bursary.entities.Application;
import com.bursary.services.BursaryApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private BursaryApplicationContext bursaryApplicationContext;

    @PostMapping
    public ResponseEntity<Application> processApplicationState(@RequestBody Application application) {
        try {
            return ResponseEntity.ok(bursaryApplicationContext.processApplicationState(application));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}

