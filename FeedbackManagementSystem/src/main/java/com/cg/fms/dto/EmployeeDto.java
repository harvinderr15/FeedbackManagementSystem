package com.cg.fms.dto;

import org.springframework.stereotype.Component;

import com.cg.fms.entites.Role;



@Component
public class EmployeeDto {
	
	private int employeeId;
	private String empName;
	private String password;
	private Role role;
	private String skills;
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDto(int employeeId, String empName, String password, Role role, String skills) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.password = password;
		this.role = role;
		this.skills = skills;
	}

	public EmployeeDto(String empName, String password, Role role, String skills) {
		super();
		this.empName = empName;
		this.password = password;
		this.role = role;
		this.skills = skills;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
}
