package com.ligy.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligy.jpademo.dao.UserDao;
import com.ligy.jpademo.model.User;
import com.ligy.jpademo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void saveUser(User user) {
		this.userDao.saveUser(user);
	}

}
