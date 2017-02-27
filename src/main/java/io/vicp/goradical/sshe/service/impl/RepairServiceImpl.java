package io.vicp.goradical.sshe.service.impl;

import io.vicp.goradical.sshe.dao.BaseDao;
import io.vicp.goradical.sshe.model.Menu;
import io.vicp.goradical.sshe.model.User;
import io.vicp.goradical.sshe.service.RepairService;
import io.vicp.goradical.sshe.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service(value = "repairService")
public class RepairServiceImpl implements RepairService{

	@Autowired
	private BaseDao<Menu> menuDao;

	@Autowired
	private BaseDao<User> userDao;

	@Override
	public void repair() {
		repairUser();
		repairMenu();
	}

	private void repairUser() {
		Map<String, Object> map = new HashMap();
		map.put("name", "root");
		User user = userDao.get("from User u where u.name = :name and u.id != 'bb6bb290-3b18-4e9f-a1ac-0ee2f9ab9792'", map);
		if (user != null) {
			user.setModifyTime(new Date());
			user.setName(UUID.randomUUID().toString());
		}

		User root = new User();
		root.setId("bb6bb290-3b18-4e9f-a1ac-0ee2f9ab9792");
		root.setName("root");
		root.setPwd(DataUtil.md5("root"));
		root.setModifyTime(new Date());
		userDao.saveOrUpdate(root);
	}

	private void repairMenu() {
		Menu root = new Menu();
		root.setId("038b923e-3edb-root-be40-80eb508be047");
		root.setText("首页");
		root.setUrl("");
		menuDao.saveOrUpdate(root);

		Menu sysManager = new Menu();
		sysManager.setId("038b923e-3edb-xtgl-be40-80eb508be047");
		sysManager.setMenu(root);
		sysManager.setText("系统管理");
		sysManager.setUrl("");
		menuDao.saveOrUpdate(sysManager);

		Menu userManager = new Menu();
		userManager.setId("038b923e-3edb-yhgl-be40-80eb508be047");
		userManager.setMenu(sysManager);
		userManager.setText("用户管理");
		userManager.setUrl("/admin/user-manager.jsp");
		menuDao.saveOrUpdate(userManager);

		Menu roleManager = new Menu();
		roleManager.setId("038b923e-3edb-jsgl-be40-80eb508be047");
		roleManager.setMenu(sysManager);
		roleManager.setText("角色管理");
		roleManager.setUrl("");
		menuDao.saveOrUpdate(roleManager);

		Menu rightManager = new Menu();
		rightManager.setId("038b923e-3edb-rigl-be40-80eb508be047");
		rightManager.setMenu(sysManager);
		rightManager.setText("权限管理");
		rightManager.setUrl("");
		menuDao.saveOrUpdate(rightManager);

		Menu menuManager = new Menu();
		menuManager.setId("038b923e-3edb-mugl-be40-80eb508be047");
		menuManager.setMenu(sysManager);
		menuManager.setText("菜单管理");
		menuManager.setUrl("");
		menuDao.saveOrUpdate(menuManager);

		Menu bugManager = new Menu();
		bugManager.setId("038b923e-3edb-bggl-be40-80eb508be047");
		bugManager.setMenu(sysManager);
		bugManager.setText("bug管理");
		bugManager.setUrl("");
		menuDao.saveOrUpdate(bugManager);
	}
}
