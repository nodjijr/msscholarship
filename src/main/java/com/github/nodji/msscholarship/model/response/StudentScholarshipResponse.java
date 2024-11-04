package com.github.nodji.msscholarship.model.response;

import java.math.BigDecimal;

import com.github.nodji.msscholarship.model.entity.StudentScholarshipEntity;
import com.github.nodji.msscholarship.model.enums.FlagType;

public record StudentScholarshipResponse(String name, FlagType flag, BigDecimal range) {
	
	public static StudentScholarshipResponse of(StudentScholarshipEntity entity) {
		return new StudentScholarshipResponse(entity.getScholarship().getName(), entity.getScholarship().getFlag(), entity.getRange());
	}

}
