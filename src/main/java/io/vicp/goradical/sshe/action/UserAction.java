package io.vicp.goradical.sshe.action;

import com.opensymphony.xwork2.ActionSupport;
import io.vicp.goradical.sshe.model.User;
import io.vicp.goradical.sshe.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Date;
import java.util.UUID;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "userAction")
public class UserAction extends ActionSupport{
	private static final Logger LOG = LogManager.getLogger(UserAction.class);

	@Autowired
	private UserService userService;

	public void test() {
		LOG.info("进入Action");
		LOG.info("update");
		LOG.info(WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()));
	}

	public void addUser() {
		User user = new User();
		user.setUuid(UUID.randomUUID().toString());
		user.setName("radical from web!");
		user.setCreateTime(new Date());
		userService.save(user);
	}
}
