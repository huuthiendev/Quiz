package com.tma.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.tma.authentication.Auth;
import com.tma.customField.UserView;
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

	@JsonView(UserView.AdvancedView.class)
	@RequestMapping(value = "/id={id}", method = RequestMethod.GET)
	@ResponseBody
    public User findUser(@PathVariable int id) {
	   return userDao.getUserById(id);
    }
   
	@Auth(role = {Auth.Role.ADMIN})
	@JsonView(UserView.BasicView.class)
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

   	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String check_login(@RequestParam("user") String user, @RequestParam("pass") String pass, HttpSession session, HttpServletResponse response){
   		User us = userDao.checkLogin(user, pass);
		
		if(us != null){
			if(us.getRole()==1){
				session.setAttribute("isLogin", true);
				session.setAttribute("user", us.getName());
				session.setAttribute("role", Auth.Role.ADMIN);
			} else if(us.getRole()==2){
				session.setAttribute("isLogin", true);
				session.setAttribute("user", us.getName());
				session.setAttribute("role", Auth.Role.MODERATOR);
			} else {
				session.setAttribute("isLogin", true);
				session.setAttribute("user", us.getName());
				session.setAttribute("role", Auth.Role.USER);
			}
			return "Login successful! Hi: "+ us.getName();
		}
		return "Username or password incorrect!";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpSession session, HttpServletResponse response) throws IOException {
		session.removeAttribute("isLogin");
		session.removeAttribute("user");
		session.removeAttribute("role");
		response.getWriter().print("Logout successful! Good bye!");	
	}
   
}
