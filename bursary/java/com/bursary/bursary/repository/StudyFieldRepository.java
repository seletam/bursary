package com.bursary.bursary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bursary.bursary.entities.Study;

public interface StudyFieldRepository extends JpaRepository<Study, Long>{

}