package com.goalkeeper.hcb.security.model;
 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
 

public class User   {
	 
	
	private String id; 
	 
	@Size(min=1,max=45)
	@NotNull
	private String lastName;

	@Size(min=1,max=45, message = "Your first name must between 1 and 45 characters")
	@NotNull
	protected String firstName;  

	/**
	 * Username, in our app, mobile number is the username
	 */
	@Size(min=1,max=45)
	@NotNull
	protected String mobileNumber;
 
	private boolean mobileConfirmed = false;
 
	@Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$", message="Please enter a valid email address.")
	@NotNull
	private String emailAddress;

	private boolean deleted;   

	private Timestamp createdAt;
	
	private String updatedBy;
	
	public String getFirstName() {
		return firstName;
	}
 
	
	private String password;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	 
	public User(String firstName, String mobileNumber,String emailAddress){
		this.firstName = firstName; 
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress; 
		 		
	}
	
	public User(){}

	public User(String mobileNumber, String encryptedPassword) {
		this.mobileNumber = mobileNumber;
		this.password= encryptedPassword;
	}
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
  

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
 

	public boolean isMobileConfirmed() {
		return mobileConfirmed;
	}

	public void setMobileConfirmed(boolean mobileConfirmed) {
		this.mobileConfirmed = mobileConfirmed;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	} 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList();
	}
}
