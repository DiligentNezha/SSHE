package io.vicp.goradical.sshe.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	Serializable save(T t);

	void delete(T t);

	void update(T t);

	void saveOrUpdate(T t);

	T get(String hql);
	T get(String hql, Map<String, Object> params);

	List<T> find(String hql);
	List<T> find(String hql, Map<String, Object> params);
	List<T> find(String hql, int page, int rows);
	List<T> find(String hql, Map<String, Object> params, int page, int rows);

	Long count(String hql);
	Long count(String hql, Map<String, Object> params);
}
