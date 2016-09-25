package com.ligy.jpademo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ligy.jpademo.dao.UserDao;
import com.ligy.jpademo.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext  
    private EntityManager entityManager;

	@Override
	public void saveUser(User user) {
		entityManager.persist(user);
	}

}
