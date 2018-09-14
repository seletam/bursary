package com.bursary.bursary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bursary.bursary.entities.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {

}
