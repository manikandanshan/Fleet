package com.fleet.common.util;

public interface Constants {
	
	public static String FEATURE_SELECT_BY_ROLE = "from Feature f where f.Id IN (select featureId from RolePrivilege rp where rp.roleId = :roleId)";
	
	public static String PRIVILEGE_SELECT_BY_ROLE = "from Privilege p where p.Id IN (select rp.privilegeId from RolePrivilege rp where rp.roleId = :roleId and rp.featureId = :featureId)";
	                      
	
	

}
