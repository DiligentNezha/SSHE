package io.vicp.goradical.sshe.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.web.context.support.WebApplicationContextUtils;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "userAction")
@Result(name = "SUCCESS", location = "/index.jsp")
public class UserAction extends ActionSupport{
	private static final Logger LOG = LogManager.getLogger(UserAction.class);


	public String test() {
		LOG.info("进入Action");
		LOG.info("update");
		LOG.info(WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext()));
		return SUCCESS;
	}
}
