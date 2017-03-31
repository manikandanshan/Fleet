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

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author shine
 *
 */
@Entity
@Table(name = "fm_vendor_detail")
public class VendorDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public VendorDetail() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "IDENTIFICATION_No", nullable = false)
	private Integer identificationNo;
	
	@NotNull
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull
	@Column(name = "PREFERED_VENDOR_STATUS", nullable = false)
	private Boolean preferedVendorStatus;

	@NotNull
	@Column(name = "SERVICE_TYPE", nullable = false)
	private String serviceType;
	
	@NotNull
	@Column(name = "ACTIVE_FLAG", nullable = false)
	private Boolean activeFlag;
	
	@NotNull
	@Column(name = "CONTACT_PERSON_NAME", nullable = false)
	private String contactPersonName;
	
	@NotNull
	@Column(name = "CONTACT_TYPE_ID", nullable = false)
	private Integer contactTypeId;
	
	@NotNull
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@NotNull
	@Column(name = "URL", nullable = false)
	private String url;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MODIFIED_ON", nullable = true)
	private Date modifiedOn;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorId")
	 private Set<ProductVendor> productVendors;
	
	public Integer getId() {
		return id;
	}

	public Set<ProductVendor> getProductVendors() {
		return productVendors;
	}

	public void setProductVendors(Set<ProductVendor> productVendors) {
		this.productVendors = productVendors;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(Integer identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPreferedVendorStatus() {
		return preferedVendorStatus;
	}

	public void setPreferedVendorStatus(Boolean preferedVendorStatus) {
		this.preferedVendorStatus = preferedVendorStatus;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public Integer getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(Integer contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		builder.append("VendorDetail [id=").append(id)
				.append(", identificationNo=").append(identificationNo)
				.append(", name=").append(name)
				.append(", preferedVendorStatus=").append(preferedVendorStatus)
				.append(", serviceType=").append(serviceType)
				.append(", activeFlag=").append(activeFlag)
				.append(", contactPersonName=").append(contactPersonName)
				.append(", contactTypeId=").append(contactTypeId)
				.append(", address=").append(address).append(", url=")
				.append(url).append(", createdOn=").append(createdOn)
				.append(", modifiedOn=").append(modifiedOn)
				.append("]");
		return builder.toString();
	}

}
