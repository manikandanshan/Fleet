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




@Entity
@Table(name = "fm_product_vendor")
public class ProductVendor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7305210676489547719L;
	
	public ProductVendor()
	{
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "AVERAGE_LEAD_TIME", nullable = false)
	private Integer averageLeadTime;
	
	@NotNull
	@Column(name = "STANDARD_PRICE", nullable = false)
	private Double standardPrice;
	
	 @NotNull	
	@Column(name = "LAST_RECEIPT_COST", nullable = false)
	private Double lastReceiptCost;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "LAST_RECEIPT_DATE", nullable = false)
	private Date lastReceiptDate;
	
	@Column(name = "MIN_ORDER_QTY", nullable = true)
	private Integer minOrderQty;
	
	@Column(name = "MAX_ORDER_QTY", nullable = true)
	private Integer maxOrderQty;
	
	@Column(name = "ON_ORDER_QTY", nullable = true)
	private Integer onOrderQty;	

	@NotNull
	@Column(name = "UNIT_MEASURE_CODE", nullable = false)
	private String unitMeasureCode;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = true)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = true)
	private Date modifiedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="VENDOR_ID", nullable = true) 
	private VendorDetail vendorId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAverageLeadTime() {
		return averageLeadTime;
	}

	public void setAverageLeadTime(Integer averageLeadTime) {
		this.averageLeadTime = averageLeadTime;
	}

	public Double getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(Double standardPrice) {
		this.standardPrice = standardPrice;
	}

	public Double getLastReceiptCost() {
		return lastReceiptCost;
	}

	public void setLastReceiptCost(Double lastReceiptCost) {
		this.lastReceiptCost = lastReceiptCost;
	}

	public Date getLastReceiptDate() {
		return lastReceiptDate;
	}

	public void setLastReceiptDate(Date lastReceiptDate) {
		this.lastReceiptDate = lastReceiptDate;
	}

	public Integer getMinOrderQty() {
		return minOrderQty;
	}

	public void setMinOrderQty(Integer minOrderQty) {
		this.minOrderQty = minOrderQty;
	}

	public Integer getMaxOrderQty() {
		return maxOrderQty;
	}

	public void setMaxOrderQty(Integer maxOrderQty) {
		this.maxOrderQty = maxOrderQty;
	}

	public Integer getOnOrderQty() {
		return onOrderQty;
	}

	public void setOnOrderQty(Integer onOrderQty) {
		this.onOrderQty = onOrderQty;
	}

	public String getUnitMeasureCode() {
		return unitMeasureCode;
	}

	public void setUnitMeasureCode(String unitMeasureCode) {
		this.unitMeasureCode = unitMeasureCode;
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

	public VendorDetail getVendorId() {
		return vendorId;
	}

	public void setVendorId(VendorDetail vendorId) {
		this.vendorId = vendorId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductVendor [id=").append(id)
				.append(", averageLeadTime=").append(averageLeadTime)
				.append(", standardPrice=").append(standardPrice)
				.append(", lastReceiptCost=").append(lastReceiptCost)
				.append(", lastReceiptDate=").append(lastReceiptDate)
				.append(", minOrderQty=").append(minOrderQty)
				.append(", maxOrderQty=").append(maxOrderQty)
				.append(", onOrderQty=").append(onOrderQty)
				.append(", unitMeasureCode=").append(unitMeasureCode)
				.append(", createdOn=").append(createdOn)
				.append(", modifiedOn=").append(modifiedOn)
				.append(", vendorId=").append(vendorId).append("]");
		return builder.toString();
	}
	
	
	
}