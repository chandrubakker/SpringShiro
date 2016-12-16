package com.sorcererpaws.SpringShiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorcererpaws.SpringShiro.dao.UserDao;
import com.sorcererpaws.SpringShiro.entity.Role;
import com.sorcererpaws.SpringShiro.entity.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User userByEmail(String email) {
		return getUserDao().userByEmail(email);
	}

	@Override
	public List<Role> rolesByEmail(String email) {
		return getUserDao().rolesByEmail(email);
	}

	@Override
	public List<Role> rolesByUser(long userId) {
		return getUserDao().rolesByUser(userId);
	}

	//Getters and setters
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
