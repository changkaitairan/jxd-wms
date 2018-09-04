package pers.chenjunjie.wms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pers.chenjunjie.wms.enities.Inventory;
import pers.chenjunjie.wms.enities.InventoryLog;
import pers.chenjunjie.wms.enities.OperationType;
import pers.chenjunjie.wms.repositories.InventoryLogRepository;
import pers.chenjunjie.wms.repositories.InventoryRepository;
import pers.chenjunjie.wms.service.InventoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class InventoryServiceTests {

	@Resource
	private InventoryService inventoryService;
	
	@Resource
	private InventoryRepository inventoryRepository;
	
	@Resource
	private InventoryLogRepository inventoryLogRepository;
	
	@Test
	public void testCreateInventory() throws Exception {
		Inventory inventory =  new Inventory("HY", "h001", "201", "A区", 100);
		inventoryService.createInventory(inventory);
		assertEquals(Integer.valueOf(1), inventory.getId());
	}
	
}
