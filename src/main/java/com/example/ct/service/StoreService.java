package com.example.ct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rx.Observable;

import com.example.ct.domain.Store;
import com.example.ct.client.CommerceFacilityFeign;

@Service
public class StoreService {
	  private final CommerceFacilityFeign cfClient;
	  
	  @Autowired
	  public StoreService(CommerceFacilityFeign cfClient) {
	    this.cfClient = cfClient;
	  }

	/**
	   *
	   * @param id
	   * @return
	   */
	  public Observable<Store> findStore(String id) {

	    // call client to get commerceFacility and map to result
	    return cfClient.getCommerceFacilityObs(id)
	           .map(cf -> ClientDomainMapper.mapStore(cf));
	  }

}
