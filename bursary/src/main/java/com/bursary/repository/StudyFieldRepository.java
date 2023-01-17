package com.bursary.repository;

import com.bursary.entities.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyFieldRepository extends JpaRepository<Study, Long>{

}