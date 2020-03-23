package com.peer.island.employee.data.parser;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author adarsh
 * 
 * Employee Aggregator class
 *
 */
@XmlRootElement
public class Employees {

	private List<Employee> employee;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(List<Employee> employee) {
		super();
		this.employee = employee;
	}

	@XmlElement
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	

	@Override
	public String toString() {
		return "Below is list of employee"+System.lineSeparator() + employee;
	}

}
