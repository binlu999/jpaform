package com.jpa.dao;

import javax.persistence.EntityManager;

import com.jpa.entity.survey.GenericEntity;
import com.jpa.util.EntityManagerUtil;

public abstract class EntityDao <T extends GenericEntity> {
	EntityManager em = EntityManagerUtil.getEntityManager();
	private Class<T> clazz;
	
	protected EntityDao(Class<T> c){
		this.clazz=c;
	}
	public T save(T entity){
		em.getTransaction().begin();
		em.persist(entity);
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
	
}
