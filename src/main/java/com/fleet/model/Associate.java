/**
 * 
 */
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Admin
 *
 */

@Entity
@Table(name = "fm_associate")
public class Associate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -947481944948711097L;

	/**
	 * 
	 */
	public Associate() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "NUMBER",  nullable = false)
	private Integer number;
	
	@NotNull
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = true)
	private String lastName;
	@NotNull
	@Column(name = "PHONE_NO", nullable = false)
	private String phoneNo;
	@NotNull
	@Column(name = "MOBILE_NO", nullable = false)
	private String mobileNo;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DOB", nullable = false)
	private Date dob;
	@NotNull
	@Column(name = "LICENCE_NO", nullable = false)
	private String licenceNo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "LICENCE_VALID_UPTO", nullable = false)
	private Date licenceValidUpto;
	
		
	@NotNull
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "NOTES", nullable = true)
	private String notes;
	
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
	private Date modifiedOn;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CLIENT_ID", nullable = true) 
	private Client client;
	 	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="ASSOCIATE_TYPE_ID", nullable = false) 
	private  AssociateType associateTypeId;
	 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "associate")
	 private Set<Trip> associate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Date getLicenceValidUpto() {
		return licenceValidUpto;
	}

	public void setLicenceValidUpto(Date licenceValidUpto) {
		this.licenceValidUpto = licenceValidUpto;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	

	public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public AssociateType getAssociateTypeId() {
		return associateTypeId;
	}

	public void setAssociateTypeId(AssociateType associateTypeId) {
		this.associateTypeId = associateTypeId;
	}

	public Set<Trip> getAssociate() {
		return associate;
	}

	public void setAssociate(Set<Trip> associate) {
		this.associate = associate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Associate [id=").append(id).append(", number=").append(number)
				.append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", phoneNo=").append(phoneNo)
				.append(", mobileNo=").append(mobileNo).append(", email=")
				.append(email).append(", dob=").append(dob)
				.append(", licenceNo=").append(licenceNo)
				.append(", licenceValidUpto=").append(licenceValidUpto)
				.append(", address=").append(address).append(", notes=")
				.append(notes).append(", status=").append(status)
				.append(", createdOn=").append(createdOn)
				.append(", modifiedOn=").append(modifiedOn)
				.append(", clientId=").append(client)
				.append(", associateTypeId=").append(associateTypeId)
				.append(", associate=").append(associate).append("]");
		return builder.toString();
	}
}