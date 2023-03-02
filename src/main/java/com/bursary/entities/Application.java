package com.bursary.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;

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
    @Transient
    private Applicant applicant;
    @Transient
    private Status status;
    @Transient
    private Double gpa;
}
