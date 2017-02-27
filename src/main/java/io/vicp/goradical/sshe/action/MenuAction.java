package io.vicp.goradical.sshe.action;

import com.opensymphony.xwork2.ModelDriven;
import io.vicp.goradical.sshe.model.vo.MenuVo;
import io.vicp.goradical.sshe.service.MenuService;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<MenuVo>{

	@Autowired
	private MenuService menuService;

	private MenuVo menuVo = new MenuVo();

	@Override
	public MenuVo getModel() {
		return menuVo;
	}

	public void getTree() {
		List<MenuVo> tree = menuService.getTree(menuVo.getId());
		super.writeJson(tree);
	}
}
