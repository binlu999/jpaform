package com.jpa.survey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jpa.survey.entity.GenericEntity;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.util.EntityManagerUtil;

public abstract class EntityDao <T extends GenericEntity> {
	EntityManager em = EntityManagerUtil.getEntityManager();
	private Class<T> clazz;
	
	protected EntityDao(Class<T> c){
		this.clazz=c;
	}
	public T save(T entity){
		em.getTransaction().begin();
		//em.persist(entity);
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}
	
	public T merge(T entity){
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}
	
	public T find(long id){
		T entity = em.find(clazz, id);
		return entity;
	}
	
	protected List<T> runNamedQuery(String namedQuery){
		TypedQuery<T> query = this.em.createNamedQuery(namedQuery, clazz);
		List<T> list = query.getResultList();
		return list;
	}
	
}
