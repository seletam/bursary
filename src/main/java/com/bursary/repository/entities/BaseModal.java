package com.bursary.repository.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.UUID;

@Data
@AllArgsConstructor
@UserDefinedType("baseModal")
public class BaseModal {
    private String name;
}
