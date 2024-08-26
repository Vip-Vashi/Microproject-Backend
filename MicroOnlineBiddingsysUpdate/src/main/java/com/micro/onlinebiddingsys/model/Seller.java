package com.micro.onlinebiddingsys.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;
    
    @ManyToOne
    private User seller;
    
    @OneToOne
    private Product product;

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(int sellerId, User seller, Product product) {
		super();
		this.sellerId = sellerId;
		this.seller = seller;
		this.product = product;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", seller=" + seller + ", product=" + product + "]";
	}
    
    
    

}
