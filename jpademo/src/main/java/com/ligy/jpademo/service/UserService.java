package com.ligy.jpademo.service;

import org.springframework.transaction.annotation.Transactional;

import com.ligy.jpademo.model.User;

@Transactional
public interface UserService {

	public void saveUser(User user);
	
}
