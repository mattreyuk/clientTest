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
@JsonDeserialize(builder = Address.AddressBuilder.class)
public class Address {
  Double latitude;
  Double longitude;
  String url;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class AddressBuilder { }

}
