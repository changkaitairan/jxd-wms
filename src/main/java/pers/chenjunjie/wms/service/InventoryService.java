package pers.chenjunjie.wms.service;

import java.util.List;

import pers.chenjunjie.wms.enities.Inventory;

public interface InventoryService {
	
	void putInStorage(Integer id, Integer quantity);

	void putOutStorage(Integer id, Integer quantity) throws Exception;
	
	List<Inventory> listAllInventories();
	
	void createInventory(Inventory inventory);
}
