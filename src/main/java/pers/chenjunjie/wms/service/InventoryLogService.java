package pers.chenjunjie.wms.service;

import java.util.List;

import pers.chenjunjie.wms.enities.InventoryLog;

public interface InventoryLogService {
	
	List<InventoryLog> listInventoryLogs(Integer inventoryId);
	
}
