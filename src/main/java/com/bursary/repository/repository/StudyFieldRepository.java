package com.bursary.repository.repository;

import com.bursary.repository.entities.Study;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudyFieldRepository extends CassandraRepository<Study, UUID> {

}