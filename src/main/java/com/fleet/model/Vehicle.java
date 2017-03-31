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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author Admin
 *
 */

@Entity
@Table(name = "fm_vehicle")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5436591236823905731L;

	/**
	 * 
	 */
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "MAKE", nullable = false)
	private String make;
	
	@NotNull
	@Column(name = "MODEL", nullable = false)
	private String model;
	
	@NotNull
	@Column(name = "YEAR", nullable = false)
	private Integer year;
	
	@NotNull
	@Column(name = "COLOR", nullable = false)
	private String color;
		
	@NotNull
	@Column(name = "FUEL_CAPACITY", nullable = false)
	private Integer fuelCapacity;
	
	@NotNull
	@Column(name = "ENGINE_NO", nullable = false)
	private String engineNo;
	
	@NotNull
	@Column(name = "ODOMETER_TYPE", nullable = false)
	private String odometerType;
	
	@NotNull
	@Column(name = "DEPARTMENT_ID", nullable = false)
	private Integer departmentId;
	
	@NotNull
	@Column(name = "VIN", unique= true, nullable = false)
	private String vin;
	
	@Column(name = "NOTE", nullable =true)
	private String note;
	
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
		
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = false)
	private Date modifiedOn;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="Fuel_Type_ID", nullable = true )
	private FuelType fuelType;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="Vehicle_Type_ID", nullable = true )
	private VehicleType vehicleType ;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
	public Set<VehicleInsurance> vehicleInsurances;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
	public Set<Service> services;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
	public Set<FitnessCertificate> fitnessCertificates;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(Integer fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getOdometerType() {
		return odometerType;
	}

	public void setOdometerType(String odometerType) {
		this.odometerType = odometerType;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Set<VehicleInsurance> getVehicleInsurances() {
		return vehicleInsurances;
	}

	public void setVehicleInsurances(Set<VehicleInsurance> vehicleInsurances) {
		this.vehicleInsurances = vehicleInsurances;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Set<FitnessCertificate> getFitnessCertificates() {
		return fitnessCertificates;
	}

	public void setFitnessCertificates(Set<FitnessCertificate> fitnessCertificates) {
		this.fitnessCertificates = fitnessCertificates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [id=");
		builder.append(id);
		builder.append(", make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(", year=");
		builder.append(year);
		builder.append(", color=");
		builder.append(color);
		builder.append(", fuelCapacity=");
		builder.append(fuelCapacity);
		builder.append(", engineNo=");
		builder.append(engineNo);
		builder.append(", odometerType=");
		builder.append(odometerType);
		builder.append(", departmentId=");
		builder.append(departmentId);
		builder.append(", vin=");
		builder.append(vin);
		builder.append(", note=");
		builder.append(note);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", fuelType=");
		builder.append(fuelType);
		builder.append(", vehicleType=");
		builder.append(vehicleType);
		builder.append(", vehicleInsurances=");
		builder.append(vehicleInsurances);
		builder.append(", services=");
		builder.append(services);
		builder.append(", fitnessCertificates=");
		builder.append(fitnessCertificates);
		builder.append("]");
		return builder.toString();
	}
	
}
