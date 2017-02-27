package io.vicp.goradical.sshe.listener;

import io.vicp.goradical.sshe.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 初始化权限监听器，在spring初始化完成后立即调用
 */
@Component
public class RepairListener implements ApplicationListener {

	@Autowired
	private RepairService repairService;

	@Override
	public void onApplicationEvent(ApplicationEvent ae) {
		//上下文刷新事件
		if (ae instanceof ContextRefreshedEvent) {
			repairService.repair();
		}
	}

}
