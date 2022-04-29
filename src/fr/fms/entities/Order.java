package fr.fms.entities;

import java.util.Arrays;
import java.util.Date;

public class Order {
	private int orderId;
	private double orderAmount;
	private Date date;
	private String customerName;
	private int customerId;
	double[] total;

	public Order(int orderId, Date date, String customerName, int customerId, double[] total) {
		this.orderId = orderId;
		this.date = date;
		this.customerName = customerName;
		this.customerId = customerId;

	}

	public Order(int orderId, Date date, int customerId, double[] total) {
		this.orderId = orderId;
		this.date = date;
		this.customerId = customerId;
		this.total = total;
	}

	public Order(Date date, int customerId, double[] total) {
		this.date = date;
		this.customerId = customerId;
		this.total = total;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double[] getTotal() {
		return total;
	}

	public void setTotal(double[] total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", date=" + date + ", customerName="
				+ customerName + ", customerId=" + customerId + ", total=" + Arrays.toString(total) + "]";
	}

}