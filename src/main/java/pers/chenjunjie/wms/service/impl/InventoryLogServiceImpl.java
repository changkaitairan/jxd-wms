package pers.chenjunjie.wms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.chenjunjie.wms.enities.InventoryLog;
import pers.chenjunjie.wms.repositories.InventoryLogRepository;
import pers.chenjunjie.wms.service.InventoryLogService;

@Service
public class InventoryLogServiceImpl implements InventoryLogService {
	
	@Resource
	private InventoryLogRepository inventoryLogRepository;

	@Override
	public List<InventoryLog> listInventoryLogs(Integer inventoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
