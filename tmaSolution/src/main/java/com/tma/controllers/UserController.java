package com.tma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.domain.User;
import com.tma.services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private UserService userDao;
	
	@Autowired
	public void setUserDao(UserService userDao) {
		this.userDao = userDao;
	}

	@RequestMapping(value = "/id={id}", method = RequestMethod.GET)
	@ResponseBody
    public User findUser(@PathVariable int id) {
	   return userDao.getUserById(id);
    }
   
	@RequestMapping(method = RequestMethod.GET)
   	@ResponseBody
   	public List<User> listUsers() {
       List<User> users = userDao.findAllUser();
       
	   return users;
    }
   
	@RequestMapping(value = "/delete/id={id}", method = RequestMethod.GET)
   	public void deleteUser(@PathVariable int id){
	   userDao.deleteUser(id);
   	}
   
   	@RequestMapping(value = "/add", method = RequestMethod.POST)
   	@ResponseBody
   	public String addUser(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("role") int role)
   	{
	   userDao.addUser(name, password, role);
	   
	   return name + " added";
   	}
   
   	@RequestMapping(value = "/update", method = RequestMethod.POST)
   	public boolean updateUser(
		   @RequestParam("id") int id,
		   @RequestParam("name") String name,
		   @RequestParam("password") String password,
		   @RequestParam("role") int role
		   )
   	{
	   return userDao.updateUser(id, name, password, role);
   	}
//   	
//   	@RequestMapping(value = "/test", method = RequestMethod.GET)
//   	@ResponseBody
//   	public String name(@RequestParam("name") String name){
//   		return userDao.findUserByQuery(name).getName();
//   	}
   
}
