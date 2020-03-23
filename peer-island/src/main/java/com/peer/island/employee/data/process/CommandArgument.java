package com.peer.island.employee.data.process;

import java.util.Map;

public class CommandArgument {

	private String operation;

	private Map<String, String> propertiesMap;

	public CommandArgument(String operation, Map<String, String> propertiesMap) {
		super();
		this.operation = operation;
		this.propertiesMap = propertiesMap;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Map<String, String> getPropertiesMap() {
		return propertiesMap;
	}

	public void setPropertiesMap(Map<String, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

}
