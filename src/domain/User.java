package domain;

import java.io.Serializable;

public class User implements Serializable{
	
	private String username;
	private String password;
	private String rePassword;
	private String mail;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", rePassword=" + rePassword + ", mail=" + mail + "]";
	}
	
	

}
