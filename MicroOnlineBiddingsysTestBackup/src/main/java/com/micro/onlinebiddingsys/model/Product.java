package com.micro.onlinebiddingsys.model;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String name;
    private String description;
    private String productstatus;
    @Lob
    @Column(length = 104857600)
    private byte[] imageBlob;

    private String imageUrl;
    private Double startingPrice;
    private LocalDateTime auctionStartTimeDate;
    private LocalDateTime endTimeDate;
    private Double currentBiddingPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    

	public Product() {
		super();
	}



	public Product(int productId, String name, String description, String productstatus, byte[] imageBlob,
			String imageUrl, Double startingPrice, LocalDateTime auctionStartTimeDate, LocalDateTime endTimeDate,
			Double currentBiddingPrice, User user) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.productstatus = productstatus;
		this.imageBlob = imageBlob;
		this.imageUrl = imageUrl;
		this.startingPrice = startingPrice;
		this.auctionStartTimeDate = auctionStartTimeDate;
		this.endTimeDate = endTimeDate;
		this.currentBiddingPrice = currentBiddingPrice;
		this.user = user;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getProductstatus() {
		return productstatus;
	}



	public void setProductstatus(String productstatus) {
		this.productstatus = productstatus;
	}



	public byte[] getImageBlob() {
		return imageBlob;
	}



	public void setImageBlob(byte[] imageBlob) {
		this.imageBlob = imageBlob;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public Double getStartingPrice() {
		return startingPrice;
	}



	public void setStartingPrice(Double startingPrice) {
		this.startingPrice = startingPrice;
	}



	public LocalDateTime getAuctionStartTimeDate() {
		return auctionStartTimeDate;
	}



	public void setAuctionStartTimeDate(LocalDateTime auctionStartTimeDate) {
		this.auctionStartTimeDate = auctionStartTimeDate;
	}



	public LocalDateTime getEndTimeDate() {
		return endTimeDate;
	}



	public void setEndTimeDate(LocalDateTime endTimeDate) {
		this.endTimeDate = endTimeDate;
	}



	public Double getCurrentBiddingPrice() {
		return currentBiddingPrice;
	}



	public void setCurrentBiddingPrice(Double currentBiddingPrice) {
		this.currentBiddingPrice = currentBiddingPrice;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description
				+ ", productstatus=" + productstatus + ", imageBlob=" + Arrays.toString(imageBlob) + ", imageUrl="
				+ imageUrl + ", startingPrice=" + startingPrice + ", auctionStartTimeDate=" + auctionStartTimeDate
				+ ", endTimeDate=" + endTimeDate + ", currentBiddingPrice=" + currentBiddingPrice + ", user=" + user
				+ "]";
	}

}