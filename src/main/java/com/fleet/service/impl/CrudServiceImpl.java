package com.fleet.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleet.dao.CrudDao;
import com.fleet.service.CrudService;

@Transactional
public abstract class CrudServiceImpl<T extends Serializable>  implements CrudService<T>{

	@Autowired
	CrudDao<T> crudDao;
	
	@Override
	public T create(T entity) {
		return crudDao.create(entity);
	}

	@Override
	public T findOne(Integer id) {
		return crudDao.findOne(id);
	}

	@Override
	public List<T> findAllById(List<Integer> idList) {
		return crudDao.findAllById(idList);
	}

	@Override
	public T save(T entity) {
		return crudDao.save(entity);
	}
	
	@Override
	public List<T> save(List<T> entities) throws NullPointerException{
		return crudDao.save(entities);
	}

	@Override
	public void remove(T entity) {
		crudDao.remove(entity);
	}
	
	@Override
	public void remove(final List<T> entities) {
		crudDao.remove(entities);
	}

	@Override
	public List<T> findAll() {
		return crudDao.findAll();
	}

	@Override
	public T findByProperty(String propertyName, Object value) {
		return crudDao.findByProperty(propertyName, value);
	}

	@Override
	public List<T> findAllByProperty(String propertyName, Object value) {
		return crudDao.findAllByProperty(propertyName, value);
	}

	@Override
	public List<T> findAllByProperties(Map<String, Object> properties) {
		return crudDao.findAllByProperties(properties);
	}

	@Override
	public T findByProperties(Map<String, Object> properties) {
		return crudDao.findByProperties(properties);
	}

	@Override
	public List<T> findAllById(List<Integer> idList, Map<String, Object> properties) {
		return crudDao.findAllById(idList, properties);
	}


}
