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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "fm_service")
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2977109231928814970L;

	/**
	 * 
	 */
	public Service() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ENTRY_DATE", nullable = false)
	private Date entryDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "RELEASE_DATE", nullable = false)
	private Date releaseDate;
	
	@NotNull
	@Column(name = "AMOUNT", nullable = false)
	private Double amount;
	
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = true)
    private Date modifiedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_ID", nullable = false)
	public Vehicle vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERVICE_STATION_ID", nullable = false )
	public ServiceStation serviceStation;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
	 private Set<ServiceDetail> serviceDetails = new HashSet<ServiceDetail>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
 
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

	public ServiceStation getServiceStation() {
		return serviceStation;
	}

	public void setServiceStation(ServiceStation serviceStation) {
		this.serviceStation = serviceStation;
	}

	public Set<ServiceDetail> getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(Set<ServiceDetail> serviceDetails) {
		this.serviceDetails = serviceDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Service [id=");
		builder.append(id);
		builder.append(", entryDate=");
		builder.append(entryDate);
		builder.append(", releaseDate=");
		builder.append(releaseDate);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append(", serviceStation=");
		builder.append(serviceStation);
		builder.append(", serviceDetails=");
		builder.append(serviceDetails);
		builder.append("]");
		return builder.toString();
	}

	
	
}
