package com.tma.services;

import java.util.List;

import com.tma.domain.User;

public interface UserService {
	List<User> findAllUser();
	void deleteUser(Integer Id);
	void addUser(String name, String pass, int role);
	User getUserById(Integer Id);
	void save(User obj);
	boolean updateUser(int id, String name, String password, int role);
	User checkLogin(String user, String pass);
}
