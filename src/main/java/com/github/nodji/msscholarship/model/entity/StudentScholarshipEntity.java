package com.github.nodji.msscholarship.model.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "studentscholarships")
public class StudentScholarshipEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
	private String code;
	@ManyToOne
	@JoinColumn(name = "scholarshipId")
	private ScholarshipEntity scholarship;
	@Column
	private BigDecimal range;

}
