package com.usdj.springcloud.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @program: eureka
 * @description:
 * @author: JerryDeng
 * @create: 2019-03-08 14:10
 **/
@RestController
public class HellController {

	protected Logger logger = LoggerFactory.getLogger(HellController.class);

	@Autowired
	@Qualifier(value = "restTemplate")
	private RestTemplate restTemplate;

	

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return restTemplate.getForEntity("http://SERVICE/hello", String.class).getBody();
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public String hello2() {
		ServiceInstance instance = this.loadBalancerClient.choose("SERVICE");
		URI helloUri = URI.create(String.format("http://%s:%s/hello", instance.getHost(), instance.getPort()));
		logger.info("Target service uri = {}. ", helloUri.toString());
		return new RestTemplate().getForEntity(helloUri, String.class).getBody();
	}


}
