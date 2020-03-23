package com.peer.island.extend.employee.data;

public class Address {

	private String doorNo;
	private String street;
	private String town;
	private String state;

	public Address(String doorNo, String street, String town, String state) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.town = town;
		this.state = state;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "doorNo=" + doorNo + ", street=" + street + ", town=" + town + ", state=" + state;
	}
	
	

}
