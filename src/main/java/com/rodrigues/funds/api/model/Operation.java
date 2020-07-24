package com.rodrigues.funds.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rodrigues.funds.api.enums.Type;

@Entity
@Table(name = "TB_OPERATION")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	private Fund fund;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	private Type type;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "PRICE_TAX")
	private double priceTax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceTax() {
		return priceTax;
	}

	public void setPriceTax(double priceTax) {
		this.priceTax = priceTax;
	}
	
}
