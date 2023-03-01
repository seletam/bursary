package com.bursary.entities;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Table
@Getter
public class Study  extends BaseModal {
    @Builder(builderMethodName = "studyBuilder")
    public Study(UUID id, String name) {
        super(id, name);
    }
}