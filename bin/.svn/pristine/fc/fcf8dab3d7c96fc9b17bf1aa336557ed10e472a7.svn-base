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
@Table(name = "fm_trip_detail")
public class TripDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1894054221657468414L;

	/**
	 * 
	 */
	public TripDetail() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "TRIP_ID", nullable = false)
	private Trip trip=new Trip();
	
	@NotNull
	@Column(name = "FROM_ADDRESS", nullable = false)
	private String fromAddress;
	
	@NotNull
	@Column(name = "TO_ADDRESS", nullable = false)
	private String toAddress;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "END_DATE", nullable = false)
	private Date endDate;
	
	@NotNull
	@Column(name = "DISTANCE", nullable = false)
	private Integer distance;
	
	@NotNull
	@Column(name = "TYPE_OF_GOOD", nullable = false)
	private String typeOfGood;
	
	@NotNull
	@Column(name = "ODOMETER_START_READING", nullable = false)
	private Integer odometerStartReading;
	
	@NotNull
	@Column(name = "ODOMETER_END_READING", nullable = false)
	private Integer odometerEndReading;
	
	@NotNull
	@Column(name = "FUEL_CONSUMPTION", nullable = false)
	private Integer fuelConsumption;
	
	@NotNull
	@Column(name = "AMOUNT", nullable = false)
	private Integer Amount;
	
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
    private Date modifiedOn;

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getTypeOfGood() {
		return typeOfGood;
	}

	public void setTypeOfGood(String typeOfGood) {
		this.typeOfGood = typeOfGood;
	}

	public Integer getOdometerStartReading() {
		return odometerStartReading;
	}

	public void setOdometerStartReading(Integer odometerStartReading) {
		this.odometerStartReading = odometerStartReading;
	}

	public Integer getOdometerEndReading() {
		return odometerEndReading;
	}

	public void setOdometerEndReading(Integer odometerEndReading) {
		this.odometerEndReading = odometerEndReading;
	}

	public Integer getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(Integer fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public Integer getAmount() {
		return Amount;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
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
		StringBuilder builder = new StringBuilder();
		builder.append("TripDetail [id=").append(id).append(", trip=")
				.append(trip).append(", fromAddress=").append(fromAddress)
				.append(", toAddress=").append(toAddress)
				.append(", startDate=").append(startDate).append(", endDate=")
				.append(endDate).append(", distance=").append(distance)
				.append(", typeOfGood=").append(typeOfGood)
				.append(", odometerStartReading=").append(odometerStartReading)
				.append(", odometerEndReading=").append(odometerEndReading)
				.append(", fuelConsumption=").append(fuelConsumption)
				.append(", Amount=").append(Amount).append(", status=")
				.append(status).append(", createdOn=").append(createdOn)
				.append(", modifiedOn=").append(modifiedOn).append("]");
		return builder.toString();
	}

}
