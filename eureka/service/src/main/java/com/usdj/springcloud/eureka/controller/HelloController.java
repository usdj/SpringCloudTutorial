package com.usdj.springcloud.eureka.controller;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: eureka
 * @description:
 * @author: JerryDeng
 * @create: 2019-03-08 12:54
 **/
@RestController
public class HelloController {

	protected Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private EurekaInstanceConfig eurekaInstanceConfig;

	@Value("${server.port}")
	private int serverPort = 0;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		this.logger.info("/hello, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(),eurekaInstanceConfig.getHostName(false));
		return "Hello, Spring Cloud Eureka! Running Port is" + String.valueOf(serverPort);
	}
}
