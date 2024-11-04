package com.github.nodji.msscholarship.subscriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nodji.msscholarship.model.entity.ScholarshipEntity;
import com.github.nodji.msscholarship.model.entity.StudentScholarshipEntity;
import com.github.nodji.msscholarship.model.request.CreateScholarshipRequest;
import com.github.nodji.msscholarship.repository.ScholarshipRepository;
import com.github.nodji.msscholarship.service.StudentScholarshipService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CreateScholarshipSubscriber {
	
	@Autowired
	private ScholarshipRepository scholarshipRepository;
	@Autowired
	private StudentScholarshipService studentScholarshipService;
	
	@RabbitListener(queues = "${mq.queues.create-scholarship-queue}")
	public void onMessage(@Payload String payload) {
		System.out.println("Received message: " + payload);
        try {
            var mapper = new ObjectMapper();

            CreateScholarshipRequest data = mapper.readValue(payload, CreateScholarshipRequest.class);
            ScholarshipEntity scholarship = scholarshipRepository.findById(data.scholarshipId()).orElseThrow();

            StudentScholarshipEntity studentscholarship = new StudentScholarshipEntity();
            studentscholarship.setScholarship(scholarship);
            studentscholarship.setCode(data.code());
            studentscholarship.setRange(data.range());

            studentScholarshipService.save(studentscholarship);

        }catch (Exception e){
            log.error("Erro ao receber solicitacao de criação de bolsa de estudo: {} ", e.getMessage());
        }		
		
	}

}
