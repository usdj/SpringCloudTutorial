package com.usdj.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: eureka
 * @description:
 * @author: JerryDeng
 * @create: 2019-03-08 14:10
 **/
@RestController
public class HellController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return restTemplate.getForEntity("http://SERVICE/hello", String.class).getBody();
	}
}
