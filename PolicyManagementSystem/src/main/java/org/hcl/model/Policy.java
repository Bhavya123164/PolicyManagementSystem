package org.hcl.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity

public class Policy {
	@Id
	private int id;
	@NotEmpty

	private String policyType;
	@NotEmpty

	private String policyName;
	@NotEmpty

	private String companyName;
	private Integer years;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Policy(String policyType, String policyName, String companyName, Integer years) {
		super();
		this.policyType = policyType;
		this.policyName = policyName;
		this.companyName = companyName;
		this.years = years;
	}

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

}
