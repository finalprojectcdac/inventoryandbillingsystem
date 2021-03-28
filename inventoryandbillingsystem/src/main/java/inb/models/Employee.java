package inb.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String empId;
	
	private String privilege, name,password,email;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(String empId, String privilege, String name, String password, String email) {
		super();
		this.empId = empId;
		this.privilege = privilege;
		this.name = name;
		this.password = password;
		this.email = email;
	}



	public String getEmpId() {
		return empId;
	}



	public void setEmpId(String empId) {
		this.empId = empId;
	}



	public String getPrivilege() {
		return privilege;
	}



	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", privilege=" + privilege + ", name=" + name + ", password=" + password
				+ ", email=" + email + "]";
	}

	
}
