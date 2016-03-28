package com.jpa.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jpa.survey.entity.GenericEntity;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.util.EntityManagerUtil;

public abstract class EntityDao<T extends GenericEntity> {
	EntityManager em = EntityManagerUtil.getEntityManager();
	private Class<T> clazz;

	protected EntityDao(Class<T> c) {
		this.clazz = c;
	}

	public T save(T entity) {
		em.getTransaction().begin();
		// em.persist(entity);
		T e=em.merge(entity);
		em.getTransaction().commit();
		return e;
	}

	public T merge(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	public T find(long id) {
		T entity = em.find(clazz, id);
		return entity;
	}
	
	protected List<T> runNamedTypedQuery(String namedQuery) {
		TypedQuery<T> query = this.em.createNamedQuery(namedQuery, clazz);
		List<T> list = query.getResultList();
		return list;
	}

	protected int runNamedQuery(String namedQuery) {
		em.getTransaction().begin();
		Query query = this.em.createNamedQuery(namedQuery);
		int count=query.executeUpdate();
		em.getTransaction().commit();
		return count;
	}

}
