package com.usdj.springcloud.zuul.api;

import com.usdj.springcloud.zuul.user.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: zuul
 * @description: UserEndpoint
 * @author: JerryDeng
 * @create: 2019-03-10 12:11
 **/
@RestController
@RequestMapping("/users")
public class UserEndpoint {
	@Value("${server.port:8200}")
	private int serverPort = 8200;

	@RequestMapping(value = "/{loginName}", method = RequestMethod.GET)
	public User detail(@PathVariable String loginName) {
		String memos = "I come form " + this.serverPort;
		return new User(loginName, loginName, "/avatar/default.png", memos);
	}

}
