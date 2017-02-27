package io.vicp.goradical.sshe.service.impl;

import io.vicp.goradical.sshe.dao.BaseDao;
import io.vicp.goradical.sshe.model.Menu;
import io.vicp.goradical.sshe.model.vo.MenuVo;
import io.vicp.goradical.sshe.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Autowired
	private BaseDao<Menu> menuDao;

	@Override
	public List<MenuVo> getTree(String id) {
		List<MenuVo> menuVos = new ArrayList<>();
		String hql;
		Map<String, Object> map = null;
		if (id == null || "".equals(id)) {
			//查询所有根节点
			hql = "from Menu m where m.menu is null";
		} else {
			//异步查询当前id下的所有子节点
			hql = "from Menu m where m.menu.id = :id";
			map = new HashMap();
			map.put("id", id);
		}
		List<Menu> list = menuDao.find(hql, map);
		if (list != null && list.size() > 0) {
			for (Menu menu : list) {
				MenuVo menuVo = new MenuVo();
				BeanUtils.copyProperties(menu, menuVo);
				Set<Menu> menus = menu.getMenus();
				if (menus != null && !menus.isEmpty()) {
					menuVo.setState("closed");//节点以文件夹形式体现
				} else {
					menuVo.setState("open");//节点以文件形式体现
				}
				menuVos.add(menuVo);
			}
		}
		return menuVos;
	}
}
