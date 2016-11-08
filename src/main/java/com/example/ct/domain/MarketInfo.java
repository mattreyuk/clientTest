package com.example.ct.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(Include.NON_EMPTY)
@JsonDeserialize(builder = MarketInfo.MarketInfoBuilder.class)
public class MarketInfo {

  String id;
  String type;
  String code;
  String commercefacilityId;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class MarketInfoBuilder { }
}
