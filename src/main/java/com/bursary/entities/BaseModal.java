package com.bursary.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@Data
@AllArgsConstructor
@MappedSuperclass
public class BaseModal {
    @PrimaryKey
    @Setter(AccessLevel.NONE)
    @PrimaryKeyColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
}
