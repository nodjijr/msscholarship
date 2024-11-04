package com.github.nodji.msscholarship.model.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.github.nodji.msscholarship.model.enums.FlagType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder	
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "scholarchips")
public class ScholarshipEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
	private String name;
	@Column
	@Enumerated(EnumType.STRING)
	private FlagType flag;
	@Column
	private BigDecimal walue;
	@Column
	private BigDecimal range;

}
