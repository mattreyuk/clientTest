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
@JsonDeserialize(builder = CommerceFacility.CommerceFacilityBuilder.class)
public class CommerceFacility {

  String id;
  String name;
  String description;
  Address address;
  List<MarketInfo> marketInfos;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class CommerceFacilityBuilder { }

}
