package com.github.nodji.msscholarship.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.nodji.msscholarship.model.entity.StudentScholarshipEntity;

public interface StudentScholarshipRepository extends JpaRepository<StudentScholarshipEntity, UUID> {

	List<StudentScholarshipEntity> findByCode(String code);

}
