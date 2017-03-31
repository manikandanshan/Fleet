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
@Table(name = "fm_service_detail")
public class ServiceDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2815170426006512697L;

	/**
	 * 
	 */
	public ServiceDetail() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "VEHICLE_SERVICE_ID", nullable = true)
     private Service service;
	
	@NotNull
	@Column(name = "ACTIVITY", nullable = false)
	private String activity;
	
	@NotNull
	@Column(name = "AMOUNT", nullable = false)
	private double amount;
	
	@NotNull
	@Column(name = "VAT", nullable = false)
	private double vat;
	
	@NotNull
	@Column(name = "TAX", nullable = false)
	private double tax;
	
	@NotNull
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = true)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = true)
    private Date modifiedOn;
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
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
		builder.append("ServiceDetail [id=").append(id).append(", service=")
				.append(service).append(", activity=").append(activity)
				.append(", amount=").append(amount).append(", vat=")
				.append(vat).append(", tax=").append(tax).append(", status=")
				.append(status).append(", createdOn=").append(createdOn)
				.append(", modifiedOn=").append(modifiedOn)
				.append("]");
		return builder.toString();
	}
	

}
