package com.example.ct.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder
@JsonInclude(Include.NON_EMPTY)
@JsonDeserialize(builder = Store.StoreBuilder.class)
public class Store {
  String id;
  String name;
  Address address;

  @Singular
  List<Department> departments;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class StoreBuilder { }

}
