package com.sorcererpaws.SpringShiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sorcererpaws.SpringShiro.entity.Role;
import com.sorcererpaws.SpringShiro.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User userByEmail(String email) {
		TypedQuery<User> typedQuery = getEntityManager().createQuery("SELECT U FROM User U WHERE U.email = :email", User.class);
		typedQuery.setParameter("email", email);
		try {
			return typedQuery.getSingleResult();
		} catch (NonUniqueResultException|NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Role> rolesByEmail(String email) {
		return null;
	}

	@Override
	public List<Role> rolesByUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	//Getters and setters
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
