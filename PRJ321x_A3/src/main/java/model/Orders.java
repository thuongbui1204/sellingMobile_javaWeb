package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders {
	private int orderId;
	private double price;
	private int status;
	private Date orderdate;
	private String address;
	private String phoneNumber;
	private ArrayList<ProductOrder> lp;
	private String userMail;
	private Date receiveDate;
	private String discount;
	
	public Orders() {};
	public Orders(float price, int status, java.sql.Date orderdate, String address, String phoneNumber, String userMail, Date receiveDate, String discount){
		this.price=price;
		this.status=status;
		this.orderdate=orderdate;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.userMail=userMail;
		this.receiveDate=receiveDate;
		this.discount=discount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date date) {
		this.orderdate = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ArrayList<ProductOrder> getLp() {
		return lp;
	}

	public void setLp(ArrayList<ProductOrder> lp) {
		this.lp = lp;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
