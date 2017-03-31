/**
 * 
 */
package com.fleet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "fm_fuel_station")
public class FuelStation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3265836079723353058L;

	/**
	 * 
	 */
	public FuelStation() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "CODE", nullable = false)
	private String code;
	
	@Size(min = 3, max = 25)
	@NotNull
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "PHONE_NO", nullable = false)
	private String phoneNo;
	@NotNull
	@Column(name = "MOBILE_NO", nullable = false)
	private String mobileNo;
	
	@NotNull
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	

	@Column(name = "TYPES_OF_FUEL", nullable = true)
	private String typesOfFuel;
	
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
    private Date modifiedOn;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getTypesOfFuel() {
		return typesOfFuel;
	}
	public void setTypesOfFuel(String typesOfFuel) {
		this.typesOfFuel = typesOfFuel;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "FuelStation [id=" + id + ", code=" + code + ", name=" + name
				+ ", phoneNo=" + phoneNo + ", mobileNo=" + mobileNo
				+ ", address=" + address + ", typesOfFuel=" + typesOfFuel
				+ ", status=" + status + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", createdBy=" + "]";
	}
	

}
