package com.fleet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "fm_associate_type")
public class AssociateType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1673179104781835285L;

	public AssociateType() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

@Size(min = 3, max = 50)
@Column(name = "NAME", nullable = false)
private String name;

@NotNull
@Column(name = "CODE", nullable = false)
private String code;
@NotNull
@Column(name = "STATUS", nullable = false)
private String status;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Column(name = "CREATED_ON", nullable = false)
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


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
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

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("AssociateType [id=").append(id).append(", name=")
			.append(name).append(", code=").append(code).append(", status=")
			.append(status).append(", createdOn=").append(createdOn)
			.append(", modifiedOn=").append(modifiedOn).append("]");
	return builder.toString();
}



}
