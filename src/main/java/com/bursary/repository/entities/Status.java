package com.bursary.repository.entities;

import com.bursary.services.state.ApplicationStatus;
import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.UUID;

@Data
@UserDefinedType("status")
@Builder(builderMethodName = "StatusBuilder")
public class Status {

    @Id
    @PrimaryKey
    @Setter(AccessLevel.NONE)
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CassandraType(type = CassandraType.Name.INT)
    private ApplicationStatus status;
    @Nonnull
    private String reason;
    @CreatedDate
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private String createdDate;
    @LastModifiedDate
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private String modifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;
    @CreatedBy
    private String approvedBy;
}
