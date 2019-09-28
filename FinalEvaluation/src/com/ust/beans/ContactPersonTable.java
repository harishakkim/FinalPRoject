package com.ust.beans;

public class ContactPersonTable {
	
	private int personId;
	private String personName;
	private int vendorId;
	private String department;
	private String eMail;
	private String phone;
	public ContactPersonTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactPersonTable(int personId, String personName, int vendorId,
			String department, String eMail, String phone) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.vendorId = vendorId;
		this.department = department;
		this.eMail = eMail;
		this.phone = phone;
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
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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
	@Override
	public String toString() {
		return "ContactPersonTable [personId=" + personId + ", personName="
				+ personName + ", vendorId=" + vendorId + ", department="
				+ department + ", eMail=" + eMail + ", phone=" + phone + "]";
	}
	
	

}
