package com.fleet.dao.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fleet.dao.CrudDao;

public class CrudDaoImpl<T extends Serializable> implements CrudDao<T>{

	private transient final Class<T> entityClass;

	@SuppressWarnings("unchecked")
	CrudDaoImpl() {
		entityClass = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Autowired
	private SessionFactory sessionFactory;
	//added
  	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public T create(final T entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findOne(final Integer id) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllById(final List<Integer> idList) {
		if (idList == null || idList.isEmpty()) {
			return Collections.EMPTY_LIST;
		}

		Criteria critera = sessionFactory.getCurrentSession().createCriteria(entityClass);
		critera.add(Restrictions.in("id", idList));
		return critera.list();
	}
	
	
  @SuppressWarnings("unchecked")
  @Override
  public List<T> findAllById(final List<Integer> idList,
      Map<String, Object> properties) {
    if (idList == null || idList.isEmpty()) {
      return Collections.EMPTY_LIST;
    }
    Session session = sessionFactory.getCurrentSession();
    
    Criteria criteria = session.createCriteria(entityClass);
    criteria.add(Restrictions.in("id", idList));
    for (Map.Entry<String, Object> entry : properties.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      if (key != null) {
        if (key.contains(".")) {
          String[] str = key.split("\\.");
          if (str.length > 0) {

            if (value != null) {
              criteria.createAlias(str[0], str[0]);
              criteria.add(Restrictions.eq(key, value));
            } else {
              criteria.setFetchMode(str[0], FetchMode.JOIN);
            }
          }
        } else {
          if (value != null) {
            criteria.add(Restrictions.eq(key, value));
          }
        }
      }
    }

    return criteria.list();
  }

	@Override
	public T save(final T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> save(final List<T> entities) throws NullPointerException, ConstraintViolationException {
		if (entities == null || entities.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		for (T entity : entities) {
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		}
		return entities;
	}

	@Override
	public void remove(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	@Override
	public void remove(List<T> entities) {
		for (T entity : entities) {
			remove(entity);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria critera = sessionFactory.getCurrentSession().createCriteria(entityClass);
		return critera.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findByProperty(String propertyName, Object value) {
		Criteria critera = sessionFactory.getCurrentSession().createCriteria(entityClass);
		critera.add(Restrictions.eq(propertyName, value));
		T result = (T) critera.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findByProperties(Map<String, Object> properties) {
		Criteria critera = sessionFactory.getCurrentSession().createCriteria(entityClass);
		for (Map.Entry<String, Object> entry : properties.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (key.contains(".")) {
				String[] str = key.split("\\.");
				if (str.length > 0) {
					//critera.createAlias(str[0], str[0]);
					//critera.add(Restrictions.eq(key, value));
					if(value != null){
						critera.createAlias(str[0], str[0]);
						critera.add(Restrictions.eq(key, value));
					}else{
						critera.setFetchMode(str[0], FetchMode.JOIN);
					}
				}

			} else {
				if(value != null){
					critera.add(Restrictions.eq(key, value));
				}else{
					critera.setFetchMode(key, FetchMode.JOIN);
				}
			}
		}
		T result = (T) critera.uniqueResult();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAllByProperty(String propertyName, Object value) {
		Criteria critera = sessionFactory.getCurrentSession().createCriteria(entityClass);
		critera.add(Restrictions.eq(propertyName, value));
		List<T> list = critera.list();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAllByProperties(Map<String, Object> properties) {
		Criteria critera = sessionFactory.getCurrentSession().createCriteria(entityClass);
		for (Map.Entry<String, Object> entry : properties.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if(key != null){
				if (key.contains(".")) {
					String[] str = key.split("\\.");
					if (str.length > 0) {
						
						if(value != null){
							critera.createAlias(str[0], str[0]);
							critera.add(Restrictions.eq(key, value));
						}else{
							critera.setFetchMode(str[0], FetchMode.JOIN);
						}
					}
				} else {
					if(value != null){
						critera.add(Restrictions.eq(key, value));
					}
				}
			}
		}
		List<T> list = critera.list();
		return list;
	}
	//added based on spring mvc security
	@SuppressWarnings("unchecked")
	public T getByKey(Integer key) {
		return (T) getSession().get(entityClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	
	
	protected Criteria createEntityCriteria(){
		return sessionFactory.getCurrentSession().createCriteria(entityClass);
	}

	

}
