package com.bursary.repository;

import com.bursary.entities.Study;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudyFieldRepository extends BursaryRepository<Study, UUID> {

}