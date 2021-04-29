package com.cg.bookstore.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookorder_master")
public class BookOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private LocalDate orderDate;
	private double orderTotal;
	private String status;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address ShippingAddress;
	private String paymentMethod;
	private String recipientName;
	private String recipientPhone;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		ShippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public BookOrder() {
		super();
	}

	public BookOrder(Customer customer, LocalDate orderDate, double orderTotal, String status, Address shippingAddress,
			String paymentMethod, String recipientName, String recipientPhone) {
		super();
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.status = status;
		ShippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
	}

	public BookOrder(int orderId, Customer customer, LocalDate orderDate, double orderTotal, String status,
			Address shippingAddress, String paymentMethod, String recipientName, String recipientPhone) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.status = status;
		ShippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
	}

}
