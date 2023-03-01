package com.bursary.entities;

import com.bursary.state.ApplicationStatus;
import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@Builder(builderMethodName = "StatusBuilder")
public class Status {
    @Id
    @PrimaryKey
    @Setter(AccessLevel.NONE)
    @PrimaryKeyColumn(name = "id", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private ApplicationStatus status;

    private String reason;

    @Nonnull
    private String approvedBy;

    @Column
    private String modifiedBy;
}
