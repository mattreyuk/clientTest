package com.example.ct.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.codec.ErrorDecoder;

	@Configuration
	public class FeignConfiguration {  
	    @Bean
	    public Logger.Level feignLogger() {
	        return Logger.Level.FULL;
	    }
	    	    
	}