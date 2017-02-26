package io.vicp.goradical.sshe.action;

import com.opensymphony.xwork2.ModelDriven;
import io.vicp.goradical.sshe.model.vo.Json;
import io.vicp.goradical.sshe.model.vo.UserVo;
import io.vicp.goradical.sshe.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/")
@Action(value = "userAction")
public class UserAction extends BaseAction implements ModelDriven<UserVo>{
	private static final Logger LOG = LogManager.getLogger(UserAction.class);

	@Autowired
	private UserService userService;

	private UserVo userVo = new UserVo();

	public void reg() {
		Json json = new Json();
		try {
			userService.save(userVo);
			json.setSuccess(true);
			json.setMsg("注册成功!");
		} catch (Exception e) {
			json.setMsg("注册失败!");
			e.printStackTrace();
		} finally {
			super.writeJson(json);
		}
	}

	public void login() {
		UserVo resultUser = userService.login(userVo);
		Json json= new Json();
		if (resultUser != null) {
			json.setSuccess(true);
			json.setMsg("登陆成功!");
		} else {
			json.setMsg("登陆失败,用户名或密码错误!");
		}
		super.writeJson(json);
	}


	@Override
	public UserVo getModel() {
		return userVo;
	}
}
