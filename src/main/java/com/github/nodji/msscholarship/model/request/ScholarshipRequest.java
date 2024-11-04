package com.github.nodji.msscholarship.model.request;

import java.math.BigDecimal;

import com.github.nodji.msscholarship.model.enums.FlagType;

public record ScholarshipRequest(String name, FlagType flag, BigDecimal walue, BigDecimal range) {

}
