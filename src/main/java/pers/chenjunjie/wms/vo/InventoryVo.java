package pers.chenjunjie.wms.vo;

import pers.chenjunjie.wms.enities.Inventory;
import pers.chenjunjie.wms.enities.InventoryLog;

public class InventoryVo {
	
	private Inventory inventory;
	
	private InventoryLog inventoryLog;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public InventoryLog getInventoryLog() {
		return inventoryLog;
	}

	public void setInventoryLog(InventoryLog inventoryLog) {
		this.inventoryLog = inventoryLog;
	}
	
}
