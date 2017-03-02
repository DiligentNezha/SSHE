package io.vicp.goradical.sshe.service;

import io.vicp.goradical.sshe.model.vo.DataGridVo;
import io.vicp.goradical.sshe.model.vo.UserVo;

public interface UserService {

	UserVo save(UserVo userVo);

	UserVo login(UserVo userVo);

	DataGridVo datagrid(UserVo userVo);

	void remove(String ids);

	UserVo edit(UserVo userVo);
}
