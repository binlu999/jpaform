package com.jpa.test;

import com.jpa.dao.EntityDao;
import com.jpa.entity.survey.GenericEntity;
import com.jpa.entity.survey.SurveyForm;
import com.jpa.util.EntityManagerUtil;

public abstract class GenericTest<T1 extends EntityDao<T2>, T2 extends GenericEntity> {
	protected T1 dao;

	protected GenericTest(Class<T1> c) throws InstantiationException,
			IllegalAccessException {
		EntityManagerUtil.getEntityManager();
		this.dao = c.newInstance();
	}

	abstract public T2 creatOne();

	public T2 save(T2 entity) {
		T2 e = this.dao.save(entity);
		return e;
	}

	public T2 merge(T2 entity) {
		T2 e = this.dao.merge(entity);
		return e;
	}

	public T2 find(long id) {
		T2 entity = this.dao.find(id);
		assert (entity != null);
		return entity;
	}

}
