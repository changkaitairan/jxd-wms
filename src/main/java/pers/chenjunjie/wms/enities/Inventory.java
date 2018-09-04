package pers.chenjunjie.wms.enities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String customer;

	@Column(nullable = false)
	private String colorCode;

	@Column(nullable = false)
	private String category;

	@Column(nullable = false)
	private String warehouse;

	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false)
	private Integer in;
	
	@Column(nullable = false, columnDefinition = "INT NOT NULL DEFAULT 0", insertable = false)
	private Integer out;

	@OneToMany
	private List<InventoryLog> inventoryLogs;

	public Inventory() {
	}

	public Inventory(String customer, String colorCode, String category, String warehouse, Integer quantity) {
		super();
		this.customer = customer;
		this.colorCode = colorCode;
		this.category = category;
		this.warehouse = warehouse;
		this.quantity = quantity;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<InventoryLog> getInventoryLogs() {
		return inventoryLogs;
	}

	public void setInventoryLogs(List<InventoryLog> inventoryLogs) {
		this.inventoryLogs = inventoryLogs;
	}

	public Integer getIn() {
		return in;
	}

	public void setIn(Integer in) {
		this.in = in;
	}

	public Integer getOut() {
		return out;
	}

	public void setOut(Integer out) {
		this.out = out;
	}

}
