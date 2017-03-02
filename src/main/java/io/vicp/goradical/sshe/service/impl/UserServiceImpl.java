package io.vicp.goradical.sshe.service.impl;

import io.vicp.goradical.sshe.dao.BaseDao;
import io.vicp.goradical.sshe.model.User;
import io.vicp.goradical.sshe.model.vo.DataGridVo;
import io.vicp.goradical.sshe.model.vo.UserVo;
import io.vicp.goradical.sshe.service.UserService;
import io.vicp.goradical.sshe.util.DataUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private BaseDao<User> userDao;

	@Override
	public UserVo save(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user, new String[]{"pwd"});
		user.setId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		user.setPwd(DataUtil.md5(userVo.getPwd()));
		userDao.save(user);
		BeanUtils.copyProperties(user, userVo);
		return userVo;
	}

	@Override
	public UserVo login(UserVo userVo) {
		String hql = "from User u where u.name = :name and u.pwd = :pwd";
		Map<String, Object> params = new HashMap();
		params.put("name", userVo.getName());
		params.put("pwd", DataUtil.md5(userVo.getPwd()));
		User user = userDao.get(hql, params);
		if (user != null) {
			return userVo;
		}
		return null;
	}

	@Override
	public DataGridVo datagrid(UserVo userVo) {
		DataGridVo dgv = new DataGridVo();
		String hql = "from User u ";
		Map<String, Object> params = new HashMap<>();
		hql = addWhere(userVo, hql, params);
		String totalHql = "select count(*) " + hql;
		if (userVo.getSort() != null) {
			hql += " order by " + userVo.getSort() + " " + userVo.getOrder();
		}
		List<User> users = userDao.find(hql, params, userVo.getPage(), userVo.getRows());
		List<UserVo> userVos = new ArrayList<>();
		if (users != null && users.size() > 0) {
			for (User user : users) {
				UserVo userVoTemp = new UserVo();
				BeanUtils.copyProperties(user, userVoTemp);
				userVos.add(userVoTemp);
			}
		}
		dgv.setTotal(userDao.count(totalHql, params));
		dgv.setRows(userVos);
		return dgv;
	}

	@Override
	public void remove(String ids) {
		String[] nids = ids.split(",");
		String hql = "delete User u where u.id in (";
		for (int i = 0; i < nids.length; i++) {
			if (i > 0) {
				hql += ",";
			}
			hql += "'" + nids[i] + "'";
		}
		hql += ")";
		userDao.executeHQL(hql);
	}

	private String addWhere(UserVo userVo, String hql, Map<String, Object> params) {
		if (userVo.getName() != null && !"".equals(userVo.getName().trim())) {
			hql += "where u.name like :name";
			params.put("name", "%%" + userVo.getName().trim() + "%%");
		}
		return hql;
	}

}
