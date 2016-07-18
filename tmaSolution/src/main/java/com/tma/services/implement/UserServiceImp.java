package com.tma.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.tma.domain.User;
import com.tma.repositories.UserRepository;
import com.tma.services.UserService;
import com.tma.tool.WebTool;

@Service
public class UserServiceImp implements UserService{
	private UserRepository Rep;
	
	@Autowired
	public void setRep(UserRepository rep) {
		Rep = rep;
	}

	@Override
	public List<User> findAllUser() {
		Iterable<User> tmpT = Rep.findAll();
		List<User> result = Lists.newArrayList(tmpT);
		return result;
	}
	
	@Override
	public void deleteUser(Integer Id) {
		Rep.delete(Id);
	}

	@Override
	public void addUser(String name, String pass, int role) {
		User user = new User();
		
		user.setName(name);
		user.setPasswordHash(WebTool.encodeHashPass(pass));
		user.setCreatedAt(WebTool.getTime());
		user.setRole(role);
		
		Rep.save(user);		
	}
	
	@Override
	public User getUserById(Integer Id) {
		return Rep.findOne(Id);
	}
	
	@Override
	public void save(User user){
		Rep.save(user);
	}

	@Override
	public boolean updateUser(int id, String name, String password, int role) {
		User user = Rep.findOne(id);
		if (user == null)
			return false;
		
		user.setName(name);
		user.setPasswordHash(password);
		user.setRole(role);
		user.setUpdatedAt(WebTool.getTime());
		
		return true;
	}
}
