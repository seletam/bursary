package com.bursary.controller;

import com.bursary.repository.entities.Application;
import com.bursary.repository.repository.ApplicationRepository;
import com.bursary.services.BursaryApplicationContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final BursaryApplicationContext bursaryApplicationContext;
    private final ApplicationRepository applicationRepository;

    @PostMapping
    public ResponseEntity<Application> processApplicationState(@Validated @RequestBody Application application) {
        return new ResponseEntity<>(bursaryApplicationContext.processApplicationState(application), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationRepository.findAllApplications(Pageable.ofSize(10)).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Application>> getApplicationById(@PathVariable("id") final UUID id) {
        return ResponseEntity.ok(applicationRepository.findById(id));
    }
}

