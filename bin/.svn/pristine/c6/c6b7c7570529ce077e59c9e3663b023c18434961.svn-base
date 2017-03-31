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

@Entity
@Table(name = "fm_service_station")
public class ServiceStation implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = 5614496384967854977L;
public ServiceStation() {

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
@Column(name = "ADDRESS", nullable = false)
private String address;
@NotNull
@Column(name = "STATUS", nullable = false)
private String status;

@DateTimeFormat(pattern = "dd/MM/yyyy")
@Column(name = "CREATED_ON", nullable = true)
private Date createdOn;

@DateTimeFormat(pattern = "dd/MM/yyyy")
@Column(name = "MODIFIED_ON", nullable = true)
private Date modifiedOn;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceStation")
public Set<Service> services;
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
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

public Set<Service> getServices() {
	return services;
}

public void setServices(Set<Service> services) {
	this.services = services;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ServiceStation [id=").append(id).append(", code=")
			.append(code).append(", name=").append(name).append(", address=")
			.append(address).append(", status=").append(status)
			.append(", createdOn=")
			.append(createdOn).append(", modifiedOn=").append(modifiedOn)
			.append(", services=").append(services).append("]");
	return builder.toString();
}


}
