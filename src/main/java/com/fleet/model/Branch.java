package com.fleet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "fm_branch")
public class Branch implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9221514406993120693L;

	public Branch()
	{
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "BRANCH_TYPE", nullable = false)
	private String branchType;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ESTABLISHED_DATE", nullable = false)
	private Date establishedDate;
	
	@NotNull	
	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String addressLine1;
	
	@NotNull	
	@Column(name = "ADDRESS_LINE2", nullable = false)
	private String addressLine2;
	
	@NotNull
	@Column(name = "CITY", nullable = false)
	private String city;
	
	

	@NotNull
	@Column(name = "STATE", nullable = false)
	private String state;

	@NotNull
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	
	@NotNull
	@Column(name = "ZIP_CODE", nullable = false)
	private String zipCode;

	@Column(name = "STD_CODE", nullable = true)
	private String stdCode;
	

	
	@NotNull
	@Column(name = "CONTACT_No1", nullable = false)
	private String contactNo1;

	@NotNull
	@Column(name = "CONTACT_No2", nullable = false)
	private String contactNo2;
	
		
	
	@Column(name = "FAX", nullable = false)
	private String  fax;
	
	@NotNull
	@Column(name = "URL", nullable = true)
	private String url;
	
	@NotNull
	@Column(name = "EMAIL_ID", nullable = false)
	private String emailId;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = true)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = true)
	private Date modifiedOn;
	 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "branchCode")
	 private Set<Company> Company;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStdCode() {
		return stdCode;
	}

	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Set<Company> getCompany() {
		return Company;
	}

	public void setCompany(Set<Company> company) {
		Company = company;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Branch [id=").append(id).append(", name=").append(name)
				.append(", branchType=").append(branchType)
				.append(", establishedDate=").append(establishedDate)
				.append(", addressLine1=").append(addressLine1)
				.append(", addressLine2=").append(addressLine2)
				.append(", city=").append(city).append(", state=")
				.append(state).append(", country=").append(country)
				.append(", zipCode=").append(zipCode).append(", stdCode=")
				.append(stdCode).append(", contactNo1=").append(contactNo1)
				.append(", contactNo2=").append(contactNo2).append(", fax=")
				.append(fax).append(", url=").append(url).append(", emailId=")
				.append(emailId).append(", createdOn=").append(createdOn)
				.append(", modifiedOn=").append(modifiedOn)
				.append(", createdBy=").append(", Company=")
				.append(Company).append("]");
		return builder.toString();
	}

	
	}
	
	
	

