package com.peer.island.extend.employee.data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employees {

	private List<EmployeeExtend> employee;

	public Employees(List<EmployeeExtend> employee) {
		super();
		this.employee = employee;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlElement
	public List<EmployeeExtend> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeExtend> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Below is list of employee" + System.lineSeparator() + employee;
	}

}
