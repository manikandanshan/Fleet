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
@Table(name = "fm_trip")
public class Trip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7190577244168188916L;

	/**
	 * 
	 */
	public Trip() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
		
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "VEHICLE_ID", nullable = true)
	 private Vehicle vehicle;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "ASSOCIATE_ID", nullable = true)
	 private Associate associate;
	
	 @NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
    private Date modifiedOn;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
	 private Set<TripDetail> tripDetails = new HashSet<TripDetail>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Associate getAssociate() {
		return associate;
	}

	public void setAssociate(Associate associate) {
		this.associate = associate;
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

	public Set<TripDetail> getTripDetails() {
		return tripDetails;
	}

	public void setTripDetails(Set<TripDetail> tripDetails) {
		this.tripDetails = tripDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trip [id=").append(id).append(", vehicle=")
				.append(vehicle).append(", associate=").append(associate)
				.append(", status=").append(status).append(", createdOn=")
				.append(createdOn).append(", modifiedOn=").append(modifiedOn)
				.append(", tripDetails=").append(tripDetails).append("]");
		return builder.toString();
	}
	
	
	
}
