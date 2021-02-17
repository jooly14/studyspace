package bean.member;

import java.util.Date;

public class MemberInfo {
	private String id;
	private String password;
	private String name;
	private Date registerDate;
	private String email;
	
	public MemberInfo() {
	}
	public MemberInfo(String id, String password, String name, Date registerDate, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
		this.email = email;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}	
