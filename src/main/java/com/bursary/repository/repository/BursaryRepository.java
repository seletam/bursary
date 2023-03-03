package com.bursary.repository.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BursaryRepository<T, ID> extends CassandraRepository<T, ID>, JpaSpecificationExecutor<T> {
}
