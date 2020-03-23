package com.peer.island.extend.employee.data;

import com.peer.island.employee.data.parser.Employee;


public class EmployeeExtend extends Employee {

	private Address address;

	public EmployeeExtend(String name, String age, String designation, Address address) {
		super(name, age, designation);
		this.address = address;
	}

	public EmployeeExtend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	@Override
	public String toString() {
		return "getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getDesignation()=" + getDesignation()+ "address=" + address ;
	}
	
	

	
	
	

}
