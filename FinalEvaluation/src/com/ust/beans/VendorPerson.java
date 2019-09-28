package com.ust.beans;

public class VendorPerson {
	private int personId;
	private String personName;
	private String department;
	private String eMail;
	private String phone;
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pinCode;
	private String isActive;
	public VendorPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorPerson(int personId, String personName, String department,
			String eMail, String phone, int vendorId, String vendorName,
			String address, String location, String service, int pinCode,
			String isActive) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.department = department;
		this.eMail = eMail;
		this.phone = phone;
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
		return "VendorPerson [personId=" + personId + ", personName="
				+ personName + ", department=" + department + ", eMail="
				+ eMail + ", phone=" + phone + ", vendorId=" + vendorId
				+ ", vendorName=" + vendorName + ", address=" + address
				+ ", location=" + location + ", service=" + service
				+ ", pinCode=" + pinCode + ", isActive=" + isActive + "]";
	}
	
	

}
