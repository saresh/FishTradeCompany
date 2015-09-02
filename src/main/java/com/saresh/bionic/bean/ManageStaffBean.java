package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Staff;
import com.saresh.bionic.service.StaffService;

@Named
@Scope("session")
public class ManageStaffBean implements Serializable {
	
	private static final long serialVersionUID = -7629382333690603827L;

	private List<Staff> staffAccounts = null;	

	@Inject
	private StaffService staffService;
	
	public String changeActiveStatus(String staffId){
		int sId = Integer.parseInt(staffId);
		
		staffService.changeActiveStatus(sId);
				
		return "/so/editStaffAccounts";
	}	
		
	public void updateStaffAccountsList(){
		staffAccounts = staffService.findAll();
	}
	
	public List<Staff> getStaffAccounts() {
		return staffAccounts;
	}

	public void setStaffAccounts(List<Staff> staffAccounts) {
		this.staffAccounts = staffAccounts;
	}

}
