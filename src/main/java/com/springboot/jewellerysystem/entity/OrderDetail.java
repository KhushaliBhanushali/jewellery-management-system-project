package com.springboot.jewellerysystem.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
	private Order order;

	@Basic
	@Column(name = "mrp", nullable = false)
	private Float mrp;

	@Basic
	@Column(name = "price", nullable = false)
	private Float price;

	@Basic
	@Column(name = "qty", nullable = false)
	private Integer qty;

	@Basic
	@Column(name = "amount", nullable = false)
	private Float amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getMrp() {
		return mrp;
	}

	public void setMrp(Float mrp) {
		this.mrp = mrp;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		return Objects.equals(id, other.id) && Objects.equals(mrp, other.mrp) && Objects.equals(price, other.price)
				&& Objects.equals(qty, other.qty) && Objects.equals(amount, other.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, mrp, price, qty, amount);
	}

	public OrderDetail() {
		super();
	}

	public OrderDetail(Float mrp, Float price, Integer qty, Float amount) {
		super();
		this.mrp = mrp;
		this.price = price;
		this.qty = qty;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", mrp=" + mrp + ", price=" + price + ", qty=" + qty + ", amount=" + amount
				+ "]";
	}
}
