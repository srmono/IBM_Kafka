package com.ibm.producer;

public class Order {

	private String isbn;
	private String productName;
	private String qty;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public Order(String isbn, String productName, String qty) {
		super();
		this.isbn = isbn;
		this.productName = productName;
		this.qty = qty;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
