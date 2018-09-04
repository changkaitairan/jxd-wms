package pers.chenjunjie.wms.enities;

public enum OperationType {
	IN("入库"), OUT("出库");
	
	private String lable;
	
	private OperationType(String lable) {
		this.lable = lable;
	}

	public String getLable() {
		return lable;
	}
}
