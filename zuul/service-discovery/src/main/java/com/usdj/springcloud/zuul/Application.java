package com.usdj.springcloud.zuul;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: zuul
 * @description: startup
 * @author: JerryDeng
 * @create: 2019-03-10 11:29
 **/
@EnableEurekaServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
	    new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
	}
}
