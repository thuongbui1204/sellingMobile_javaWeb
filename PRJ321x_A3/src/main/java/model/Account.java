package model;

public class Account {
private String usr;
private String pwd;
private int role;
private String name, address, phone;

private String messageUsr="";
private String messagePwd="";

public Account() {};

public Account(String usr, String pwd) {
	this.usr=usr;
	this.pwd=pwd;
}
public Account(String usr, String pwd, int role,
		String name, String address, String phone) {
	this.usr=usr;
	this.pwd=pwd;
	this.role=role;
	this.name=name;
	this.address=address;
	this.phone=phone;
}
public String getUsr() {
	return usr;
}
public void setUsr(String usr) {
	this.usr = usr;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public boolean validateUsr(String user) {
	if(user.equals("")) {
		this.messageUsr="* No email address";
		return false;
	}
	if(!user.matches("^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$")){
	this.messageUsr="* Email is wrong";
	return false;
	}
	this.messageUsr="";
	return true;
}

public boolean validatePwd(String pass) {
	if(pass.equals("")) {
		this.messagePwd="* No password number";
		return false;
	}

	if(pass.length()<8) {
	this.messagePwd="* Password must be 8 character at least";
	return false;
	}
	if(pass.matches("[a-z]+[A-Z]+[0-9]+[_!@#$%^&*]+")){
	this.messagePwd="* Password must inlude lowerLetter,upperLetter,number, special letter";
	return false;
	};
	this.messagePwd="";
	return true;
}


public String getMessageUsr() {
	return this.messageUsr;
}
public String getMessagePwd() {
	return this.messagePwd;
}
}

