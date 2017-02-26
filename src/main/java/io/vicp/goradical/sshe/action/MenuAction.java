package io.vicp.goradical.sshe.action;

import com.opensymphony.xwork2.ModelDriven;
import io.vicp.goradical.sshe.model.vo.MenuVo;
import org.apache.struts2.convention.annotation.Action;

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<MenuVo>{

	private MenuVo menuVo = new MenuVo();

	@Override
	public MenuVo getModel() {
		return menuVo;
	}
}
