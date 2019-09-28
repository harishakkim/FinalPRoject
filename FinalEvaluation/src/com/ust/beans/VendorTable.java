package com.ust.beans;

public class VendorTable {
	
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pinCode;
	private String isActive;
	
	public VendorTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorTable(int vendorId, String vendorName, String address,
			String location, String service, int pinCode, String isActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "VendorTable [vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", address=" + address + ", location="
				+ location + ", service=" + service + ", pinCode=" + pinCode
				+ ", isActive=" + isActive + "]";
	}
	
	

}
