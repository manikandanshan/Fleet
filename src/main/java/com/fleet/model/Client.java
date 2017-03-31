/**
 * 
 */
package com.fleet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "fm_client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -138583764849888513L;

	/**
	 * 
	 */
	public Client() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clientId;
	
	@Size(min = 3, max = 25)
	@NotNull
	@Column(name = "NAME", nullable = false)
	private String Name;
	
	@NotNull
	@Column(name = "CODE", nullable = false)
	private String code;
	
	@NotNull
	@Column(name = "PHONE_NO", nullable = false)
	private String phoneNo = "[0-9]{10}";
	
	@NotNull
	@Column(name = "MOBILE_NO", nullable = false)
	private String mobileNo;
	
	@NotNull
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
	private Date modifiedOn;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	 private Set<Associate> Associates = new HashSet<Associate>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
  private Set<User> users = new HashSet<User>(0);

	

	public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Set<Associate> getAssociates() {
		return Associates;
	}

	public void setAssociates(Set<Associate> associates) {
		Associates = associates;
	}

public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

 /* @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Client [id=");
    builder.append(clientId);
    builder.append(", Name=");
    builder.append(Name);
    builder.append(", code=");
    builder.append(code);
    builder.append(", phoneNo=");
    builder.append(phoneNo);
    builder.append(", mobileNo=");
    builder.append(mobileNo);
    builder.append(", address=");
    builder.append(address);
    builder.append(", status=");
    builder.append(status);
    builder.append(", createdOn=");
    builder.append(createdOn);
    builder.append(", modifiedOn=");
    builder.append(modifiedOn);
    builder.append(", Associates=");
    builder.append(Associates);
    builder.append(", users=");
    builder.append(users);
    builder.append("]");
    return builder.toString();
  }
*/


	
	

}
