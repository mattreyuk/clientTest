package com.example.ct.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(Include.NON_EMPTY)
@JsonDeserialize(builder = Department.DepartmentBuilder.class)
public class Department {
  String id;
  String code;
  String storeId;
	String type;
	String description;
  List<String> categoryCodes;

  @JsonPOJOBuilder(withPrefix = "")
	public static final class DepartmentBuilder { }

}
