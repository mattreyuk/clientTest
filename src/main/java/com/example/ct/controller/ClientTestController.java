package com.example.ct.controller;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import rx.Observable;
import rx.functions.Action0;

import com.example.ct.service.StoreService;
import com.example.ct.domain.Store;


@RestController
@RequestMapping(value = "/v1")
@Validated
public class ClientTestController {
	  private static final Logger LOGGER = LoggerFactory.getLogger(ClientTestController.class);
	  private final static Long DEFERRED_TIMEOUT = 2000L;

	  private final StoreService storeService;


	 @Autowired
	  public ClientTestController(StoreService storeService) {
	    this.storeService = storeService;
	  }
	  /**
	   * get store
	   * @param id
	   * @return store
	   */
	//  @PreAuthorize("#oauth2.hasScope('read')")
	  @RequestMapping(value = "stores/{id}", method = RequestMethod.GET, produces = "application/json")
	  public DeferredResult<Store> getStore(
	      @PathVariable("id") @Size(min=3, max=12) String id,
	      @RequestParam(value = "verbose", required=false, defaultValue="false") boolean verbose) {

	    LOGGER.info("finding store: {}", id);

	    Observable<Store> storeObs =
	          storeService.findStore(id);

	    DeferredResult<Store> result = new DeferredResult<>(DEFERRED_TIMEOUT);
	    storeObs
	        .subscribe(result::setResult,
	            result::setErrorResult,
	            setNotFoundWhenResultNotSet(result));
	    return result;
	  }

	  @SuppressWarnings({ "rawtypes", "unchecked" })
	  public static Action0 setNotFoundWhenResultNotSet(final DeferredResult result) {
	    return () -> {
	      if (!result.isSetOrExpired()) {
	        result.setResult(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	      }
	    };
	  }

}
