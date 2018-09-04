package pers.chenjunjie.wms.repositories;

import org.springframework.data.repository.CrudRepository;

import pers.chenjunjie.wms.enities.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer>{

	Inventory findByCustomerAndColorCodeAndCategoryAndWarehouse(String customer, String colorCode, String category, String warehouse);
	
}
