package io.vicp.goradical.sshe.action;

import io.vicp.goradical.sshe.service.RepairService;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

@Action(value = "repairAction")
public class RepairAction extends BaseAction {

	@Autowired
	private RepairService repairService;

	public void init() {
		repairService.repair();
	}

	public RepairService getRepairService() {
		return repairService;
	}

	public void setRepairService(RepairService repairService) {
		this.repairService = repairService;
	}
}
