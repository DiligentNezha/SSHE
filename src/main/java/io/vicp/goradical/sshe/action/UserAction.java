package io.vicp.goradical.sshe.action;

import com.opensymphony.xwork2.ModelDriven;
import io.vicp.goradical.sshe.model.vo.JsonVo;
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
		JsonVo jsonVo = new JsonVo();
		try {
			userService.save(userVo);
			jsonVo.setSuccess(true);
			jsonVo.setMsg("注册成功!");
		} catch (Exception e) {
			jsonVo.setMsg("注册失败!");
			e.printStackTrace();
		} finally {
			super.writeJson(jsonVo);
		}
	}

	public void login() {
		UserVo resultUser = userService.login(userVo);
		JsonVo jsonVo = new JsonVo();
		if (resultUser != null) {
			jsonVo.setSuccess(true);
			jsonVo.setMsg("登陆成功!");
		} else {
			jsonVo.setMsg("登陆失败,用户名或密码错误!");
		}
		super.writeJson(jsonVo);
	}


	@Override
	public UserVo getModel() {
		return userVo;
	}
}
