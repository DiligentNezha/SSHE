package io.vicp.goradical.sshe.service.impl;

import io.vicp.goradical.sshe.dao.BaseDao;
import io.vicp.goradical.sshe.model.User;
import io.vicp.goradical.sshe.model.vo.UserVo;
import io.vicp.goradical.sshe.service.UserService;
import io.vicp.goradical.sshe.util.DataUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private BaseDao userDao;


	@Override
	public Serializable save(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user, new String[]{"pwd"});
		user.setId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		user.setPwd(DataUtil.md5(userVo.getPwd()));
		return userDao.save(user);
	}

	@Override
	public UserVo login(UserVo userVo) {
		String hql = "from User u where u.name = '" + userVo.getName() + "' and u.pwd = '" + DataUtil.md5(userVo.getPwd()) + "'";
		User user = (User) userDao.get(hql);
		if (user != null) {
			return userVo;
		}
		return null;
	}

}
