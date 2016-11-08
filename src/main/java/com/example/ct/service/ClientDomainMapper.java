package com.example.ct.service;


import com.example.ct.domain.Address;
import com.example.ct.domain.Address.AddressBuilder;
import com.example.ct.domain.CommerceFacility;
import com.example.ct.domain.Store;


public class ClientDomainMapper {


	  public static Store mapStore(CommerceFacility cf) {
	    return Store.builder()
	                .id(cf.getId())
	                .name(cf.getName())
	                .address(mapClientAddress(cf.getAddress()))
	                .build();
	  }


	  public static Address mapClientAddress(com.example.ct.domain.Address clientAddress) {
	    AddressBuilder builder =  Address.builder();
	    if (clientAddress != null) {
	      builder.latitude(clientAddress.getLatitude())
	             .longitude(clientAddress.getLongitude())
	             .url(clientAddress.getUrl());
	    }
	    return builder.build();
	  }

	}
