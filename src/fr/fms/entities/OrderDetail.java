package fr.fms.entities;

import java.util.Date;

public class OrderDetail {
	private int orderId;
	private String productId;
	private String productName;
	private int quantity;
	private double unitaryPrice;
	private double totalPrice;

	public OrderDetail(int orderId, String productId, String productName, int quantity, double unitaryPrice, double totalPrice) {
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", unitaryPrice=" + unitaryPrice + ", totalPrice=" + totalPrice + "]";
	}
	
	
	

}