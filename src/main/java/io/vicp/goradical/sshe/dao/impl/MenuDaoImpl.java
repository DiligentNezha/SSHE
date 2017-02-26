package io.vicp.goradical.sshe.dao.impl;

import io.vicp.goradical.sshe.model.Menu;
import io.vicp.goradical.sshe.service.MenuService;
import org.springframework.stereotype.Service;

@Service("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuService {

}
