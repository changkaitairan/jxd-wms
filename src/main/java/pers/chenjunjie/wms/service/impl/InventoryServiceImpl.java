package pers.chenjunjie.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.chenjunjie.wms.enities.Inventory;
import pers.chenjunjie.wms.enities.InventoryLog;
import pers.chenjunjie.wms.enities.OperationType;
import pers.chenjunjie.wms.repositories.InventoryLogRepository;
import pers.chenjunjie.wms.repositories.InventoryRepository;
import pers.chenjunjie.wms.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Resource
	private InventoryRepository inventoryRepository;

	@Resource
	private InventoryLogRepository inventoryLogRepository;

	@Override
	public List<Inventory> listAllInventories() {
		List<Inventory> inventories = new ArrayList<Inventory>();
		Iterable<Inventory> iterable = inventoryRepository.findAll();
		for (Inventory inventory : iterable) {
			inventories.add(inventory);
		}
		return inventories;
	}

	@Override
	public void createInventory(Inventory inventory) {
		Inventory existingInventory = inventoryRepository.findByCustomerAndColorCodeAndCategoryAndWarehouse(inventory.getCustomer(), inventory.getColorCode(), inventory.getCategory(), inventory.getWarehouse());
		if (null == existingInventory) {
			inventory.setIn(inventory.getQuantity());
			inventoryRepository.save(inventory);
			InventoryLog inventoryLog = new InventoryLog(inventory, inventory.getQuantity(), OperationType.IN);
			inventoryLogRepository.save(inventoryLog);
		}
		else {
			putInStorage(existingInventory.getId(), existingInventory.getQuantity());
		}
	}

	@Override
	public void putInStorage(Integer id, Integer quantity) {
		Inventory inventory = inventoryRepository.findOne(id);
		inventory.setQuantity(inventory.getQuantity() + quantity);
		inventory.setIn(inventory.getIn() + quantity);
		inventoryRepository.save(inventory);
		
		inventoryLogRepository.save(new InventoryLog(inventory, quantity, OperationType.IN));
	}

	@Override
	public void putOutStorage(Integer id, Integer quantity) throws Exception {
		Inventory inventory = inventoryRepository.findOne(id);
		if (quantity > inventory.getQuantity()) {
			throw new Exception("剩余仓库数量不足");
		}
		inventory.setQuantity(inventory.getQuantity() - quantity);
		inventory.setOut(quantity + inventory.getOut());
		inventoryRepository.save(inventory);
		
		inventoryLogRepository.save(new InventoryLog(inventory, quantity, OperationType.OUT));
	}
}
