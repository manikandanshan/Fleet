package com.fleet.dao.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fleet.dao.RolePrivilegeDao;
import com.fleet.model.RolePrivilege;


@Repository("RolePrivilegeDao")
public class RolePrivilegeDaoImpl extends CrudDaoImpl<RolePrivilege> implements RolePrivilegeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RolePrivilege> getByRole(Integer roleId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RolePrivilege.class, "rolePrivilege")
				.add(Restrictions.eq("rolePrivilege.pk.role.id", roleId));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RolePrivilege> getByFeature(Integer featureId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RolePrivilege.class, "rolePrivilege")
				.add(Restrictions.eq("rolePrivilege.pk.feature.id", featureId));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RolePrivilege> getByPrivilege(Integer privilegeId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RolePrivilege.class, "rolePrivilege")
				.add(Restrictions.eq("rolePrivilege.pk.privilege.id", privilegeId));
		return criteria.list();
	}
	
}
