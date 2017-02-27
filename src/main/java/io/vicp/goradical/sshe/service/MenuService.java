package io.vicp.goradical.sshe.service;

import io.vicp.goradical.sshe.model.vo.MenuVo;

import java.util.List;

public interface MenuService {

	List<MenuVo> getTree(String id);
}
