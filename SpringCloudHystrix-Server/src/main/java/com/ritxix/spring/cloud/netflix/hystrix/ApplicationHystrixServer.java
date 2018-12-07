package com.ritxix.spring.cloud.netflix.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ApplicationHystrixServer {

	  @RequestMapping(value = "/temitas")
	  public String readingList(){
	    return "Estos son los temitas que devuelve Hystrix";
	  }
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationHystrixServer.class, args);

	}

}
