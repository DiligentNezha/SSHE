package io.vicp.goradical.sshe.service;

import io.vicp.goradical.sshe.model.vo.DataGridVo;
import io.vicp.goradical.sshe.model.vo.UserVo;

import java.io.Serializable;

public interface UserService {

	Serializable save(UserVo userVo);

	UserVo login(UserVo userVo);

	DataGridVo datagrid();
}
