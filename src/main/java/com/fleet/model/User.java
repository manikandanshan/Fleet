package com.fleet.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "fm_users")
public class User implements java.io.Serializable {

	
	private static final long serialVersionUID = -6279860640896842186L;

	public User() {
		
	  
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;
	
	@NotEmpty
	@Column(name="PASSWORD", nullable=false)
	private String password;
		
	@NotEmpty
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	@NotEmpty
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	@NotEmpty
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "fm_user_role", 
             joinColumns = { @JoinColumn(name = "user_id")}, 
             inverseJoinColumns = { @JoinColumn(name = "role_id") }) 
	private Set<Role> roles = new HashSet<Role>();
	
	@NotNull
  @Column(name = "NUMBER",  nullable = false)
  private Integer number;
	
	@NotNull
  @Column(name = "PHONE_NO", nullable = false)
  private String phoneNo;
 
  @Column(name = "MOBILE_NO", nullable = false)
  private String mobileNo;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Column(name = "DOB", nullable = false)
  private Date dob;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Column(name = "LICENCE_VALID_UPTO", nullable = false)
  private Date licenceValidUpto;
   
  @NotNull
  @Column(name = "LICENCE_NO", nullable = false)
  private String licenceNo;

     
  @NotNull
  @Column(name = "ADDRESS", nullable = false)
  private String address;
  
  @Column(name = "NOTES", nullable = true)
  private String notes;
  
  @NotNull
  @Column(name = "STATUS", nullable = false)
  private String status;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Column(name = "CREATED_ON", nullable = true)
  private Date createdOn;
  
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Column(name = "MODIFIED_ON", nullable = true)
  private Date modifiedOn;
	
 @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn(name="CLIENT_ID", nullable = true) 
  private  Client client;

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

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
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
 
  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }
 
  public Date getLicenceValidUpto() {
    return licenceValidUpto;
  }

  public void setLicenceValidUpto(Date licenceValidUpto) {
    this.licenceValidUpto = licenceValidUpto;
  }

  public String getLicenceNo() {
    return licenceNo;
  }

  public void setLicenceNo(String licenceNo) {
    this.licenceNo = licenceNo;
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
  
  public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}
		
	public void setPassword(String password) {
			this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

 

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

 /* @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("User [id=");
    builder.append(id);
    builder.append(", ssoId=");
    builder.append(ssoId);
    builder.append(", password=");
    builder.append(password);
    builder.append(", firstName=");
    builder.append(firstName);
    builder.append(", lastName=");
    builder.append(lastName);
    builder.append(", email=");
    builder.append(email);
    builder.append(", roles=");
    builder.append(roles);
    builder.append(", number=");
    builder.append(number);
    builder.append(", phoneNo=");
    builder.append(phoneNo);
    builder.append(", mobileNo=");
    builder.append(mobileNo);
    builder.append(", dob=");
    builder.append(dob);
    builder.append(", licenceValidUpto=");
    builder.append(licenceValidUpto);
    builder.append(", licenceNo=");
    builder.append(licenceNo);
    builder.append(", address=");
    builder.append(address);
    builder.append(", notes=");
    builder.append(notes);
    builder.append(", status=");
    builder.append(status);
    builder.append(", createdOn=");
    builder.append(createdOn);
    builder.append(", modifiedOn=");
    builder.append(modifiedOn);
    builder.append(", clientId=");
    builder.append(client);
    builder.append("]");
    return builder.toString();
  }

  */
	
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (ssoId == null) {
			if (other.ssoId != null)
				return false;
		} else if (!ssoId.equals(other.ssoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
				+ ",firstName="	+ firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}*/

	

	

	
}