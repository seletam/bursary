package com.bursary.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Study  {

	@Id
	@PrimaryKey
	@Setter(AccessLevel.NONE)
	@PrimaryKeyColumn(
			name = "id")
	private UUID id;
	private String name;
}