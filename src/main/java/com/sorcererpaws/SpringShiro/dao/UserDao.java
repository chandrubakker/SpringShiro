package com.sorcererpaws.SpringShiro.dao;

import java.util.List;

import com.sorcererpaws.SpringShiro.entity.Role;
import com.sorcererpaws.SpringShiro.entity.User;

public interface UserDao {

	public User userByEmail(String email);
	public List<Role> rolesByEmail(String email);
	public List<Role> rolesByUser(long userId);
}
