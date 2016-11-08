package com.example.ct.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ct.domain.CommerceFacility;

import rx.Observable;

	
@FeignClient(name="nphs-ref-commercefacility",
            url="${store.client.commercefacility.url:}",
           decode404=true,
           configuration = FeignConfiguration.class,
           fallback=CommerceFacilityFallback.class)

public interface CommerceFacilityFeign {

@RequestMapping(method = RequestMethod.GET, value = "/v1/commercefacilities/{id}")
Observable<CommerceFacility> getCommerceFacilityObs(@PathVariable("id") String id);
}

