package pers.chenjunjie.wms.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pers.chenjunjie.wms.enities.InventoryLog;

public interface InventoryLogRepository extends CrudRepository<InventoryLog, Integer>{

	List<InventoryLog> findByInventoryId(Integer inventroyId);
	
}
