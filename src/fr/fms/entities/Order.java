package fr.fms.entities;

import java.util.Date;

public class Order {
	private int orderId;
	private double orderAmount;
	private Date date;
	private String customerName;
	private String customerId;

	public Order(int orderId, Date date, String customerName, String customerId) {
		this.orderId = orderId;
		this.date = date;
		this.customerName = customerName;
		this.customerId = customerId;

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", date=" + date + ", customerName="
				+ customerName + ", customerId=" + customerId + "]";
	}

}