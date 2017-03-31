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
@Table(name = "fm_fitness_certificate")
public class FitnessCertificate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3763706309448890899L;

	/**
	 * 
	 */
	public FitnessCertificate() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
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
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = true)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = true)
	private Date modifiedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_ID", nullable = true)
	public Vehicle vehicle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FitnessCertificate [id=").append(id)
				.append(", validFrom=").append(validFrom).append(", amount=")
				.append(amount).append(", validUpto=").append(validUpto)
				.append(", status=").append(status).append(", createdOn=")
				.append(createdOn).append(", modifiedOn=").append(modifiedOn)
				.append(", createdBy=").append(", vehicle=")
				.append(vehicle).append("]");
		return builder.toString();
	}


	
	
}
