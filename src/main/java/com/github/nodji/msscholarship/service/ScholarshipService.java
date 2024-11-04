package com.github.nodji.msscholarship.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nodji.msscholarship.model.entity.ScholarshipEntity;
import com.github.nodji.msscholarship.repository.ScholarshipRepository;

import jakarta.transaction.Transactional;


@Service
public class ScholarshipService {
	
	@Autowired
	private ScholarshipRepository repository;
	
	@Transactional
	public ScholarshipEntity save(ScholarshipEntity entity) {
		return repository.save(entity);
	}

	public List<ScholarshipEntity> findByValue(Long value) {
		return repository.findByWalueLessThanEqual(BigDecimal.valueOf(value));
	}

}
