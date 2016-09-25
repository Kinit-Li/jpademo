package com.ligy.jpademo.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ligy.jpademo.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void testSaveUser() {
		User user = new User(); // person为new状态
		user.setUsername("zhang san");
		user.setPassword("111111");
		userService.saveUser(user);
	}

}
