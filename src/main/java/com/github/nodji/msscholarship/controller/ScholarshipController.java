package com.github.nodji.msscholarship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.nodji.msscholarship.model.entity.ScholarshipEntity;
import com.github.nodji.msscholarship.model.entity.StudentScholarshipEntity;
import com.github.nodji.msscholarship.model.request.ScholarshipRequest;
import com.github.nodji.msscholarship.model.response.StudentScholarshipResponse;
import com.github.nodji.msscholarship.service.ScholarshipService;
import com.github.nodji.msscholarship.service.StudentScholarshipService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("scholarships")
@Slf4j
public class ScholarshipController {

	@Autowired
	private ScholarshipService service;
	
	@Autowired
	private StudentScholarshipService studentScholarshipService;
	
	@GetMapping
	public String status() {
		log.info("Status verify of Scholarship microservices.");
		return "Ok";
	}
	
	@PostMapping("/create")
	public ResponseEntity<ScholarshipEntity> create(@RequestBody ScholarshipRequest request) {
		log.info("create: ");
		ScholarshipEntity entity = ScholarshipEntity.builder().name(request.name()).flag(request.flag()).range(request.range()).walue(request.walue()).build(); 
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
	
	@GetMapping(params = "value")
	public ResponseEntity<List<ScholarshipEntity>> getByValue(@RequestParam Long value) {
		log.info("getByValue: " + value);
		 List<ScholarshipEntity> entities = service.findByValue(value);
		if (entities.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entities);
	}
	
	@GetMapping(params = "code")
	public ResponseEntity<List<StudentScholarshipResponse>> getByCode(@RequestParam String code) {
		log.info("getByCode: " + code);
		 List<StudentScholarshipEntity> entities = studentScholarshipService.findByCode(code);

		return ResponseEntity.ok(entities.stream().map(StudentScholarshipResponse::of).toList());
	}

}
