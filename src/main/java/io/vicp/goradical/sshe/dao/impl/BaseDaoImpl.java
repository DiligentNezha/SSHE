package io.vicp.goradical.sshe.dao.impl;

import io.vicp.goradical.sshe.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(T t) {
		return sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public T get(String hql) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0) {
			return (T) list.get(0);
		}
		return null;
	}
}
