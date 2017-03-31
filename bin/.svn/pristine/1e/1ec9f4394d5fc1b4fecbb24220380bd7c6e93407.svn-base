package com.fleet.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface CrudDao<T extends Serializable> {
	T create(T entity);

	 T findOne(Integer id);

	 List<T> findAllById(List<Integer> idList);

	 T save(T entity);
	 
	 List<T> save(List<T> entities);

	 void remove(T entity);

	 List<T> findAll();

	 T findByProperty(String propertyName, Object value);

	 List<T> findAllByProperty(String propertyName, Object value);
	 
	 List<T> findAllByProperties(Map<String, Object> properties);
	 
	 T findByProperties(Map<String, Object> properties);
	 
	 List<T> findAllById(List<Integer> idList, Map<String, Object> properties);

	 void remove(List<T> entities);

}
