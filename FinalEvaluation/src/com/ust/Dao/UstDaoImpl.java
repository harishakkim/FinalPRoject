package com.ust.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.ContactPersonTable;
import com.ust.beans.UstLoginTable;
import com.ust.beans.VendorPerson;
import com.ust.beans.VendorTable;

public class UstDaoImpl {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// verify login
	public UstLoginTable login(String username, String password) {
		String sql = "select userName,password from ustLoginTable where username=? and password=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { username,
				password }, new BeanPropertyRowMapper<UstLoginTable>(
				UstLoginTable.class));
	}

	// get vendors list
	public List<VendorTable> getAllVendors() {
		return jdbcTemplate
				.query("select vendorId,vendorName,address,location,service,pinCode from vendorTable where isActive='1'",
						new RowMapper<VendorTable>() {
							public VendorTable mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorTable vendor = new VendorTable();
								vendor.setVendorId(rs.getInt(1));
								vendor.setVendorName(rs.getString(2));
								vendor.setAddress(rs.getString(3));
								vendor.setLocation(rs.getString(4));
								vendor.setService(rs.getString(5));
								vendor.setPinCode(rs.getInt(6));
								return vendor;

							}
						});
	}


	//to get vendor details by id
			public VendorPerson getVendorById(int vendorId) {
				String sql="select vc.vendorId,vc.vendorName,vc.address,vc.location,vc.service,vc.pinCode,cd.personName,cd.department,cd.email,cd.phone,cd.personId from vendortable vc join contactpersontable cd on vc.vendorId=cd.vendorId where vc.isActive='1' and vc.vendorId='"+ vendorId + "'";
				return jdbcTemplate.queryForObject(sql, new Object[] {},
						new BeanPropertyRowMapper<VendorPerson>(VendorPerson.class));
			}

	// find vendor by vendorName
	public VendorTable getVendorByName(String vendorName) {

		String sql = "select vendorId,vendorName,address,location,service,pincode from vendorTable where vendorName='"
				+ vendorName + "'";
		return jdbcTemplate.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<VendorTable>(VendorTable.class));

	}

	// find vendor by location
	public List<VendorTable> getVendorByLocation(String location) {
		return jdbcTemplate
				.query("select vendorId,vendorName,address,location,service,pincode from vendorTable where location='"
						+ location + "'", new RowMapper<VendorTable>() {
					public VendorTable mapRow(ResultSet rs, int row)
							throws SQLException {
						VendorTable vendor = new VendorTable();
						vendor.setVendorId(rs.getInt(1));
						vendor.setVendorName(rs.getString(2));
						vendor.setAddress(rs.getString(3));
						vendor.setLocation(rs.getString(4));
						vendor.setService(rs.getString(5));
						vendor.setPinCode(rs.getInt(6));
						return vendor;
					}
				});
	}



	// disable Vendor
	public int disableVendor(int vendorId) {

		String sql = "update vendorTable set isActive='0' where vendorId="
				+ vendorId + "";

		return jdbcTemplate.update(sql);
	}

	
	//to add new vendor and contact person
	public int saveVendor(VendorPerson vc) {

	String sql1 = "insert into vendorTable(vendorName,address,location,service,pinCode,isActive) values('"
	+ vc.getVendorName()
	+ "','"
	+ vc.getAddress()
	+ "','"
	+ vc.getLocation()
	+ "','"
	+ vc.getService()
	+ "',"
	+ vc.getPinCode()
	+ ","
	+ '1'
	+ ")";

	jdbcTemplate.update(sql1);

	Integer maxId = getSequence();
	String sql2="insert into contactPersonTable(vendorId,personName,department,eMail,phone) values ("
	+ maxId
	+ ",'"
	+ vc.getPersonName()
	+ "','"
	+ vc.getDepartment()
	+ "','"
	+ vc.geteMail()
	+ "','" + vc.getPhone() + "')";
	return jdbcTemplate.update(sql2);



	}

	// to get vendor id
	private Integer getSequence() {
		Integer seq;
		String sql = "select MAX(vendorId)from vendorTable";
		seq = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}

	// to update vendor and person
	public int updateVendor(int vendorId, VendorPerson vendor) {

		String sql = "update vendorTable set vendorName='"
				+ vendor.getVendorName() + "' ,address='" + vendor.getAddress()
				+ "' ,location='" + vendor.getLocation() + "',service='"
				+ vendor.getService() + "',pinCode=" + vendor.getPinCode()
				+ "where vendorId =" + vendorId;
		jdbcTemplate.update(sql);

		

		String sql1 = "update contactPersonTable set vendorId=" + vendorId
				+ ",personName='" + vendor.getPersonName() + "',department='"
				+ vendor.getDepartment() + "',eMail='" + vendor.geteMail()
				+ "',phone='" + vendor.getPhone() + "'where personId = "
				+ vendor.getPersonId();

		return jdbcTemplate.update(sql1);
	}

	// to get contactPerson by PersonId

	public List<ContactPersonTable> getContactPersonById(int vendorId) {
		return jdbcTemplate
				.query("select personId,personName,vendorId,department,email,phone from contactpersontable where vendorId="
						+ vendorId + "", new RowMapper<ContactPersonTable>() {
					public ContactPersonTable mapRow(ResultSet rs, int row)
							throws SQLException {
						ContactPersonTable person = new ContactPersonTable();
						person.setPersonId(rs.getInt(1));
						person.setPersonName(rs.getString(2));
						person.setVendorId(rs.getInt(3));
						person.setDepartment(rs.getString(4));
						person.seteMail(rs.getString(5));
						person.setPhone(rs.getString(6));
						return person;
					}
				});
	}

}
