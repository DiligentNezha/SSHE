package io.vicp.goradical.sshe.dao.impl;

import io.vicp.goradical.sshe.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(T t) {
		return getCurrentSession().save(t);
	}

	@Override
	public void delete(T t) {
		getCurrentSession().delete(t);
	}

	@Override
	public void update(T t) {
		getCurrentSession().update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public T get(String hql) {
		Query query = getCurrentSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0) {
			return (T) list.get(0);
		}
		return null;
	}

	@Override
	public T get(String hql, Map<String, Object> params) {
		Query query = getCurrentSession().createQuery(hql);
		for (String s : params.keySet()) {
			query.setParameter(s, params.get(s));
		}
		List list = query.list();
		if (list != null && list.size() > 0) {
			return (T) list.get(0);
		}
		return null;
	}

	@Override
	public List<T> find(String hql) {
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query query = getCurrentSession().createQuery(hql);
		for (String s : params.keySet()) {
			query.setParameter(s, params.get(s));
		}
		return query.list();
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		Query query = getCurrentSession().createQuery(hql);
		return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query query = getCurrentSession().createQuery(hql);
		for (String s : params.keySet()) {
			query.setParameter(s, params.get(s));
		}
		return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql) {
		Query query = getCurrentSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query query = getCurrentSession().createQuery(hql);
		for (String s : params.keySet()) {
			query.setParameter(s, params.get(s));
		}
		return (Long) query.uniqueResult();
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
