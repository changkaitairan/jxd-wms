package pers.chenjunjie.wms.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pers.chenjunjie.wms.common.Global;
import pers.chenjunjie.wms.enities.Inventory;
import pers.chenjunjie.wms.enities.InventoryLog;
import pers.chenjunjie.wms.repositories.InventoryLogRepository;
import pers.chenjunjie.wms.service.InventoryService;

@RestController
@RequestMapping("inventories")
public class InventoryController {

	@Resource
	private InventoryService inventoryService;
	
	@Resource
	private InventoryLogRepository inventoryLogRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public String createInventory(Inventory inventory) {
		inventoryService.createInventory(inventory);
		return Global.SUCCESS;
	}
	
	@RequestMapping(path="{id}/in/{quantity}", method = RequestMethod.PUT)
	public String in(@PathVariable Integer id, @PathVariable Integer quantity) {
		inventoryService.putInStorage(id, quantity);
		return Global.SUCCESS;
	}
	
	@RequestMapping(path="{id}/out/{quantity}", method = RequestMethod.PUT)
	public String out(@PathVariable Integer id, @PathVariable Integer quantity) {
		try {
			inventoryService.putOutStorage(id, quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Global.SUCCESS;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Inventory> list() {
		return inventoryService.listAllInventories();
	}
	
	@RequestMapping(path = "{inventoryId}/logs", method = RequestMethod.GET)
	public List<InventoryLog> listInventoyLogs(@PathVariable Integer inventoryId) {
		return inventoryLogRepository.findByInventoryId(inventoryId);
	}
	
}
