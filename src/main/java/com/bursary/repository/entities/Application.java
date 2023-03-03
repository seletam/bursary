package com.bursary.repository.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Data
@Builder(builderMethodName = "ApplicationBuilder")
public class Application {
    @Id
    @PrimaryKey
    @Setter(AccessLevel.NONE)
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Applicant applicant;

    @NonNull
    private Status status;
    @NonNull
    private Double gpa;
    @CreationTimestamp
    private String createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;
}
