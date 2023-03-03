package com.bursary.repository.entities;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;


@UserDefinedType
@Getter
public class Study  extends BaseModal {
    @Builder(builderMethodName = "studyBuilder")
    public Study(String name) {
        super(name);
    }
}