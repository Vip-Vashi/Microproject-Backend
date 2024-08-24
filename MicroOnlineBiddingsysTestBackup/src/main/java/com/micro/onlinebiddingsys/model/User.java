package com.micro.onlinebiddingsys.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int uid;
	    private String username;
	    private String email;
	    private String password;
	    private String contact;
		private String role = "user";
	    @Column(length = 255)
		private String address;
	    
	    public User(int uid, String username, String email, String password, String contact, String address,
				double walletAmt, byte[] profileImageUrl, String role) {
			super();
			this.uid = uid;
			this.username = username;
			this.email = email;
			this.password = password;
			this.contact = contact;
			this.address = address;
			this.walletAmt = walletAmt;
			this.profileImageUrl = profileImageUrl;
			this.role = role;
		}

		private double walletAmt;
		public User() {
			super();
		}
		
		
		
		
		public String getAddress() {
			return address;
		}




		public void setAddress(String address) {
			this.address = address;
		}




		public byte[] getProfileImageUrl() {
			return profileImageUrl;
		}




		public void setProfileImageUrl(byte[] profileImageUrl) {
			this.profileImageUrl = profileImageUrl;
		}




		public String getRole() {
			return role;
		}




		public void setRole(String role) {
			this.role = role;
		}




		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public double getWalletAmt() {
			return walletAmt;
		}
		public void setWalletAmt(double d) {
			this.walletAmt = d;
		}
		
		@Lob
		private byte[] profileImageUrl;
		
	
		
		@Override
		public String toString() {
			return "User [uid=" + uid + ", username=" + username + ", email=" + email + ", password=" + password
					+ ", contact=" + contact + ", walletAmt=" + walletAmt + "]";
		}
	    
	    
}
