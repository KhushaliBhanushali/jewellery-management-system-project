package com.springboot.jewellerysystem.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_master")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@Basic
	@Column(name = "order_date", nullable = false)
	private Date orderDate;

	@Basic
	@Column(name = "address", nullable = false, length = 255)
	private String address;

	@Basic
	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@Basic
	@Column(name = "pincode", nullable = false, length = 10)
	private String pincode;

	@Basic
	@Column(name = "order_num", nullable = false, length = 20)
	private String orderNum;

	@Basic
	@Column(name = "tracking_code", nullable = false, length = 20)
	private String trackingCode;

	@Basic
	@Column(name = "delivery_status", nullable = false, length = 20)
	private String deliveryStatus;

	@Basic
	@Column(name = "payment_type", nullable = false, length = 50)
	private String paymentType;

	@Basic
	@Column(name = "payment_status", nullable = false)
	private Integer paymentStatus;

	@Basic
	@Column(name = "payment_detail", nullable = false, length = 50)
	private String paymentDetail;

	@Basic
	@Column(name = "grand_total", nullable = false)
	private Float grandTotal;

	@Basic
	@Column(name = "discount", nullable = false)
	private Float discount;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private Set<OrderDetail> orderDetail = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public Float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetail;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(orderNum, other.orderNum)
				&& Objects.equals(trackingCode, other.trackingCode)
				&& Objects.equals(deliveryStatus, other.deliveryStatus)
				&& Objects.equals(paymentType, other.paymentType) && Objects.equals(paymentStatus, other.paymentStatus)
				&& Objects.equals(paymentDetail, other.paymentDetail) && Objects.equals(grandTotal, other.grandTotal)
				&& Objects.equals(discount, other.discount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orderDate, address, city, pincode, orderNum, trackingCode, deliveryStatus, paymentType,
				paymentStatus, paymentDetail, grandTotal, discount);
	}

	public Order() {
		super();
	}

	public Order(Date orderDate, String address, String city, String pincode, String orderNum, String trackingCode,
			String deliveryStatus, String paymentType, Integer paymentStatus, String paymentDetail, Float grandTotal,
			Float discount) {
		super();
		this.orderDate = orderDate;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.orderNum = orderNum;
		this.trackingCode = trackingCode;
		this.deliveryStatus = deliveryStatus;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentDetail = paymentDetail;
		this.grandTotal = grandTotal;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", orderNum=" + orderNum + ", trackingCode=" + trackingCode + ", deliveryStatus="
				+ deliveryStatus + ", paymentType=" + paymentType + ", paymentStatus=" + paymentStatus
				+ ", paymentDetail=" + paymentDetail + ", grandTotal=" + grandTotal + ", discount=" + discount + "]";
	}
}
