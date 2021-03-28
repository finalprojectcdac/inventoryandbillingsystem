package inb.models;

import java.util.List;

public class UResult {
	
	private int status;
	private Employee employee;
	private List<Employee> empList;
	private String reason;
	
	public UResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UResult(int status, String reason) {
		super();
		this.status = status;
		this.reason = reason;
	}

	public UResult(int status, Employee employee, List<Employee> empList, String reason) {
		super();
		this.status = status;
		this.employee = employee;
		this.empList = empList;
		this.reason = reason;
	}
	public UResult(int status, Employee employee, String reason) {
		super();
		this.status = status;
		this.employee = employee;
		this.reason = reason;
	}
	public UResult(int status, List<Employee> empList, String reason) {
		super();
		this.status = status;
		this.empList = empList;
		this.reason = reason;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "UResult [status=" + status + ", employee=" + employee + ", empList=" + empList + ", reason=" + reason
				+ "]";
	}
	
	
	

}
