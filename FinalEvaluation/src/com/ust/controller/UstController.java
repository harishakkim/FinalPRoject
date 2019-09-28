package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.Dao.UstDaoImpl;
import com.ust.beans.UstLoginTable;
import com.ust.beans.VendorPerson;
import com.ust.beans.VendorTable;

@RestController
public class UstController {

	@Autowired
	UstDaoImpl ust;

	// verify login
	@RequestMapping(value = "/ust/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public UstLoginTable selectRole(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return ust.login(username, password);
	}

	// get vendor list
	@RequestMapping(value = "/ust/vendors", method = RequestMethod.GET)
	@ResponseBody
	public List getLabTest() {
		List list = ust.getAllVendors();
		return list;
	}


	
	// view vendor list by id
			@RequestMapping(value = "/ust/vendor/{vendorId}", method = RequestMethod.GET)
			@ResponseBody
			public VendorPerson getvendors(Model m, @PathVariable("vendorId") int vendorId) {
				return ust.getVendorById(vendorId);
			}

	// find vendor by vendorName
	@RequestMapping(value = "/ust/vendorByName/{vendorName}", method = RequestMethod.GET)
	@ResponseBody
	public VendorTable getVendorByName(Model m,
			@PathVariable("vendorName") String vendorName) {

		return ust.getVendorByName(vendorName);
	}

	// find vendor by location
	@RequestMapping(value = "/ust/vendorByLocation/{location}", method = RequestMethod.GET)
	@ResponseBody
	public List getVendorByLocation(Model m,
			@PathVariable("location") String location) {
		List list;
		list = ust.getVendorByLocation(location);

		return list;
	}

	
	// disable vendor
	@RequestMapping(value = "/ust/disableVendor/{vendorId}", method = RequestMethod.PUT)
	@ResponseBody
	public void disableVendor(@PathVariable("vendorId") int vendorId) {
		ust.disableVendor(vendorId);
	}

	// to save Vendor and person
	@ResponseBody
	@RequestMapping(value = "/ust/insertVendor", method = RequestMethod.POST)
	public void insertVendor(@RequestBody VendorPerson vendor) {
		ust.saveVendor(vendor);
	}

	// to update Vendor and person
	@ResponseBody
	@RequestMapping(value = "/ust/updateVendor", method = RequestMethod.PUT)
	public void updateDoctor(@RequestBody VendorPerson vendor) {
		int vendorId = vendor.getVendorId();
		long personId = vendor.getPersonId();
		ust.updateVendor(vendorId, vendor);
	}
	// to find persons details by vendor id

			@RequestMapping(value = "/ust/person/{vendorId}", method = RequestMethod.GET)
			@ResponseBody
			public List getPersonById(Model m,@PathVariable("vendorId") int vendorId) {
				List list;
			list=ust.getContactPersonById(vendorId);
			return list;

			}
}
