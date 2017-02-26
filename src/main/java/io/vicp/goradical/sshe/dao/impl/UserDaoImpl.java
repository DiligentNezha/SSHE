package io.vicp.goradical.sshe.dao.impl;

import io.vicp.goradical.sshe.dao.UserDao;
import io.vicp.goradical.sshe.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
