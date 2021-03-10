package inb.models;

public class User {
  private String name;
 
private String mobile;
  private String city;
  public User(String name, String mobile, String city) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.city = city;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "User [name=" + name + ", mobile=" + mobile + ", city=" + city + "]";
}
}
