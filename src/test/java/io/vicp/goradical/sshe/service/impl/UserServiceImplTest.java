package io.vicp.goradical.sshe.service.impl;

import io.vicp.goradical.sshe.model.User;
import io.vicp.goradical.sshe.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.UUID;

public class UserServiceImplTest {

	private ApplicationContext ac;
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService) ac.getBean("userService");
	}

	@Test
	public void save() throws Exception {
		User user = new User();
		user.setUuid(UUID.randomUUID().toString());
		user.setName("radical");
		user.setCreateTime(new Date());
		userService.save(user);
	}

}