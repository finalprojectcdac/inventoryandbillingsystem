package inb.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	String empId;
	
	String privilege, fName,lName,password,dob,dateOfJoining,state;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", privilege=" + privilege + ", fName=" + fName + ", lName=" + lName
				+ ", password=" + password + ", dob=" + dob + ", dateOfJoining=" + dateOfJoining + ", state=" + state
				+ ", loginStatus="  + "]";
	}
	public Employee(String empId, String privilege, String fName, String lName, String password, String dob,
			String dateOfJoining, String state) {
		super();
		this.empId = empId;
		this.privilege = privilege;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.dob = dob;
		this.dateOfJoining = dateOfJoining;
		this.state = state;
		
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
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
