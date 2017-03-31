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

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "fm_fuel_type")
public class FuelType implements Serializable {
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 8675270288332649263L;
		public FuelType()
		{
		
		}

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@NotEmpty
		@Column(name = "CODE", nullable = false)
		private String code;

		@Size(min = 3, max = 50)
		@Column(name = "NAME", nullable = false)
		private String name;

		@NotNull
		@Column(name = "STATUS", nullable = false)
		private String status;

		@DateTimeFormat(pattern = "dd/MM/yyyy")
		@Column(name = "CREATED_ON", nullable = false)
		private Date createdOn;
		
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		@Column(name = "MODIFIED_ON", nullable = false)
		private Date modifiedOn;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
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
			builder.append("FuelType [id=").append(id).append(", code=")
					.append(code).append(", name=").append(name)
					.append(", status=").append(status).append(", createdOn=")
					.append(createdOn).append(", modifiedOn=")
					.append(modifiedOn).append("]");
			return builder.toString();
		}

		
}