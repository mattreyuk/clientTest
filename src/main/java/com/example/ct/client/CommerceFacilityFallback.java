package com.example.ct.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.ct.domain.CommerceFacility;

import rx.Observable;


@Component
public class CommerceFacilityFallback implements CommerceFacilityFeign {
  private static final Logger LOGGER = LoggerFactory.getLogger(CommerceFacilityFallback.class);

  @Override
  public Observable<CommerceFacility> getCommerceFacilityObs(String id) {
    //TODO what is your fallback
    LOGGER.info("fallback getCommerceFacilityObs");
    return Observable.just(getCFSingle(id, "observable"));
  }

  private CommerceFacility getCFSingle(String id, String name) {
    return CommerceFacility.builder().id(id).name(name).description("fallback").build();
  }

}
