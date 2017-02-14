package io.vicp.goradical.sshe.dao.impl;

import io.vicp.goradical.sshe.dao.UserDao;
import io.vicp.goradical.sshe.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(User user) {
		return sessionFactory.getCurrentSession().save(user);
	}
}
