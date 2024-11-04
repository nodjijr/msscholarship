package com.github.nodji.msscholarship.model.request;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateScholarshipRequest(UUID scholarshipId, String code, String address, BigDecimal range) {

}
