/**
 * 
 */
package com.fleet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Admin
 * 
 */

@Entity
@Table(name = "fm_vehicle_insurance")
public class VehicleInsurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8198742804529118526L;

	/**
	 * 
	 */
	public VehicleInsurance() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//private Vehicle vehicle = new Vehicle();
	@NotNull
	@Column(name = "INSURANCE_POLICY_NUMBER", nullable = false)
	private String insurancePolicyNumber;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "VALID_FROM", nullable = false)
	private Date validFrom;
	@NotNull
	@Column(name = "AMOUNT", nullable = false)
	private Double amount;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "VALID_UPTO", nullable = false)
	private Date validUpto;
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSURANCE_PROVIDER_ID", nullable = true)
	public InsuranceProvider insuranceProvider;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_ID", nullable = true)
	public Vehicle vehicle;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = true)
	private Date createdOn;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
	private Date modifiedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InsuranceProvider getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(InsuranceProvider insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleInsurance [id=").append(id)
				.append(", insurancePolicyNumber=")
				.append(insurancePolicyNumber).append(", validFrom=")
				.append(validFrom).append(", amount=").append(amount)
				.append(", validUpto=").append(validUpto).append(", status=")
				.append(status).append(", insuranceProvider=").append(insuranceProvider)
				.append(", vehicle=").append(vehicle).append(", createdOn=")
				.append(createdOn).append(", modifiedOn=").append(modifiedOn)
				.append("]");
		return builder.toString();
	}

	

	
}
