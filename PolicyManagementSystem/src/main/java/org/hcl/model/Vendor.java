package org.hcl.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vendor {
	@Id
	private int id;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	private int age;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String contactNumber;
	@NotEmpty
	private String userId;
	@NotEmpty
	private String vendorId;
	@NotEmpty
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(String firstName, String lastName, int age, String gender, String contactNumber, String userId,
			String vendorId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.userId = userId;
		this.vendorId = vendorId;
		this.password = password;
	}

}
