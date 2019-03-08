package com.usdj.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @program: eureka
 * @description:
 * @author: JerryDeng
 * @create: 2019-03-08 14:09
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class Application {



    @Bean
    @LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Primary
	@Bean
	RestTemplate lbcRestTemplate() {
    	return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
