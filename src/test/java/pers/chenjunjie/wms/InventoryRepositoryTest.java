package pers.chenjunjie.wms;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import pers.chenjunjie.wms.enities.Inventory;
import pers.chenjunjie.wms.repositories.InventoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InventoryRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
	
	@Resource
	private InventoryRepository inventoryRepository;
	
	@Test
	public void testSave() throws Exception {
		Inventory inventory = new Inventory("HY", "H001", "203", "A区", 100);
		Inventory savedInventory = inventoryRepository.save(inventory);
		System.out.println(savedInventory == inventory);
	}
}
