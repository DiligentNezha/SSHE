package io.vicp.goradical.sshe.service.impl;

import io.vicp.goradical.sshe.dao.UserDao;
import io.vicp.goradical.sshe.model.User;
import io.vicp.goradical.sshe.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public void test() {
		LOG.info("测试代码");
	}

	@Override
	public Serializable save(User user) {
		return userDao.save(user);
	}


}
