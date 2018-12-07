package com.ritxix.spring.cloud.netflix.hystrix;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class ClientHystrixApplication {

	
	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix";
	}
	
	@Autowired
	private BreakerPatternService breakerPatternService;

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@RequestMapping("/averquepasa")
//	public String dameTemitas() {
//		RestTemplate restTemplate = new RestTemplate();
//		URI uri = URI.create("http://localhost:8090/temitas");
//
//		return restTemplate.getForObject(uri, String.class);
//	}
	
	@RequestMapping("/averquepasa")
	public String averquepasa() {
		return breakerPatternService.dameTemitas();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ClientHystrixApplication.class, args);
	}

}
