package com.micro.onlinebiddingsys.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bidders")
public class Biddings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int bidder;
    private double biddingprice;
	public Biddings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Biddings(int bidId, Product product, int bidder, double biddingprice) {
		super();
		this.bidId = bidId;
		this.product = product;
		this.bidder = bidder;
		this.biddingprice = biddingprice;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBidder() {
		return bidder;
	}
	public void setBidder(int bidder) {
		this.bidder = bidder;
	}
	public double getBiddingprice() {
		return biddingprice;
	}
	public void setBiddingprice(double biddingprice) {
		this.biddingprice = biddingprice;
	}
	@Override
	public String toString() {
		return "Biddings [bidId=" + bidId + ", product=" + product + ", bidder=" + bidder + ", biddingprice="
				+ biddingprice + "]";
	}
	
//
//	public Biddings(int bidId, Product product) {
//		super();
//		this.bidId = bidId;
//		this.product = product;
//	}
//
//	public int getBidId() {
//		return bidId;
//	}
//
//	public void setBidId(int bidId) {
//		this.bidId = bidId;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	@Override
//	public String toString() {
//		return "Biddings [bidId=" + bidId + ", product=" + product + "]";
//	}
//    
//    

}
