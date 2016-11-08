package com.example.ct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.ct.domain.Store;
import com.example.ct.service.StoreService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=standalone,console-logging"},webEnvironment=WebEnvironment.RANDOM_PORT)
//this configuration property can also be set in test/resources/application.properties
@AutoConfigureStubRunner(ids = {"com.example.nphs.ref:nphs-ref-commercefacility:+:stubs:8989"},workOffline=true)
public class ApplicationTest {
	
//    	@Test
//    	public void shouldSuccessfullyReturnStore() {
//    		// given:
//    		String storeId="123";
//    		// when:
//    		Store resultStore =service.findStore(storeId).toBlocking().first();
//    		// then:
//    		assertEquals(resultStore.getAddress().getLatitude().toString(),"39.926705");
//         	assertEquals(resultStore.getAddress().getLongitude().toString(),"-105.125119");
//         	assertEquals(resultStore.getName(),"name-123");
//         	assertEquals(resultStore.getDepartments().size(),4);
//        }
    @Autowired
    private TestRestTemplate restTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);
    
//TODO: fix this actual test ***********
    @Test
    public void canGetStore() {
        Store resultStore = this.restTemplate.getForObject("/v1/stores/123", Store.class); 
	    LOGGER.info("returned store: {}",resultStore);
        
    	assertEquals(resultStore.getAddress().getLatitude().toString(),"39.926705");
    	assertEquals(resultStore.getAddress().getLongitude().toString(),"-105.125119");
    	assertEquals(resultStore.getName(),"name-123");
    }
}
