package io.vicp.goradical.sshe.dao;

import java.io.Serializable;
import java.util.Map;

public interface BaseDao<T> {
	Serializable save(T t);
	T get(String hql);
	T get(String hql, Object... objects);
	T get(String hql, Map<String, Object> params);
}
