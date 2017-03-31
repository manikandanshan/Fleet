package com.fleet.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "role_privilege")
@AssociationOverrides({
		@AssociationOverride(name = "pk.role", joinColumns = @JoinColumn(name = "ROLE_ID")),
		@AssociationOverride(name = "pk.feature", joinColumns = @JoinColumn(name = "FEATURE_ID")),
		@AssociationOverride(name = "pk.privilege", joinColumns = @JoinColumn(name = "PRIVILEGE_ID")) })
public class RolePrivilege implements java.io.Serializable {

	private static final long serialVersionUID = -4793855079543990822L;
	RolePrivilegeId pk = new RolePrivilegeId();

	public RolePrivilege() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	public RolePrivilegeId getPk() {
		return pk;
	}

	public void setPk(RolePrivilegeId pk) {
		this.pk = pk;
	}

	/*
	 * @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "CREATED_BY", nullable = false) User createdBy=new
	 * User();
	 * 
	 * @NotNull
	 * 
	 * @Column(name = "IS_ENABLED", nullable = false) private Integer isEnabled;
	 * 
	 * @DateTimeFormat(pattern = "dd/MM/yyyy")
	 * 
	 * @Column(name = "CREATED_ON", nullable = false) private Date createdOn;
	 * 
	 * @DateTimeFormat(pattern = "dd/MM/yyyy")
	 * 
	 * @Column(name = "MODIFIED_ON", nullable = false) private Date modifiedOn;
	 */

	@Transient
	public Role getRole() {
		return getPk().getRole();
	}

	public void setRole(Role role) {
		this.getPk().setRole(role);
	}

	@Transient
	public Feature getFeature() {
		return getPk().getFeature();
	}

	public void setFeature(Feature feature) {
		this.getPk().setFeature(feature);
	}

	@Transient
	public Privilege getPrivilege() {
		return getPk().getPrivilege();
	}

	public void setPrivilege(Privilege privilege) {
		this.getPk().setPrivilege(privilege);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePrivilege other = (RolePrivilege) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RolePrivilege [pk=");
		builder.append(pk);
		builder.append("]");
		return builder.toString();
	}

	
	

}