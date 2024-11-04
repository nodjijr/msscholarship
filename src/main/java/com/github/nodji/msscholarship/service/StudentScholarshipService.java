package com.github.nodji.msscholarship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nodji.msscholarship.model.entity.StudentScholarshipEntity;
import com.github.nodji.msscholarship.repository.StudentScholarshipRepository;

import jakarta.transaction.Transactional;


@Service
public class StudentScholarshipService {
	
	@Autowired
	private StudentScholarshipRepository repository;

	@Transactional
	public StudentScholarshipEntity save(StudentScholarshipEntity entity) {
		return repository.save(entity);
	}
	
	public List<StudentScholarshipEntity> findByCode(String code) {
		return repository.findByCode(code);
	}

}
