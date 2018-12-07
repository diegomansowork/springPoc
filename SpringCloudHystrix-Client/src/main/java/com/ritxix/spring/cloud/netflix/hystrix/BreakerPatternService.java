package com.ritxix.spring.cloud.netflix.hystrix;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BreakerPatternService {

	  private final RestTemplate restTemplate;

	  public BreakerPatternService(RestTemplate rest) {
	    this.restTemplate = rest;
	  }
	
	  @HystrixCommand(fallbackMethod = "reliable")
	  public String dameTemitas() {
	    URI uri = URI.create("http://localhost:8090/averquepasa");

	    return this.restTemplate.getForObject(uri, String.class);
	  }

	  public String reliable() {
	    return "Esto es lo que se devuelve en modo reliable";
	  }

}
