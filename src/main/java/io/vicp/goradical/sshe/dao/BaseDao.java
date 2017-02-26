package io.vicp.goradical.sshe.dao;

import java.io.Serializable;

public interface BaseDao<T> {
	Serializable save(T t);
	T get(String hql);
}
