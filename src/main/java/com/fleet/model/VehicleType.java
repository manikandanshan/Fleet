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
@Table(name = "fm_vehicle_type")
public class VehicleType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5703789204488961302L;

	/**
	 * 
	 */
	public VehicleType() {
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
	@Column(name = "WEIGHT_RANGE", nullable = false)
	private Integer weightRange;
	
	@Column(name = "PURPOSE", nullable = true)
	private String purpose;
	@NotNull
	@Column(name = "PERMIT_TYPE", nullable = false)
	private String permitType;
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
	private Date modifiedOn;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="vehicleType" ) 
	private  Set<Vehicle > vehicles ;
	 
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
	public Integer getWeightRange() {
		return weightRange;
	}
	public void setWeightRange(Integer weightRange) {
		this.weightRange = weightRange;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
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
		return "VehicleType [id=" + id + ", code=" + code + ", name=" + name
				+ ", weightRange=" + weightRange + ", purpose=" + purpose
				+ ", permitType=" + permitType + ", status=" + status
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ "]";
	}
     
}
