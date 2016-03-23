package com.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManager entityManager = null;

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory("formjpa");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

}
