package com.github.nodji.msscholarship.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.nodji.msscholarship.model.entity.ScholarshipEntity;

public interface ScholarshipRepository extends JpaRepository<ScholarshipEntity, UUID> {

	List<ScholarshipEntity> findByWalueLessThanEqual(BigDecimal value);

}
