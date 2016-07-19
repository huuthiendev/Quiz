package com.tma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.domain.UserProfile;
import com.tma.services.UserProfileService;

@Controller
@RequestMapping(value = "/user_profile")
public class UserProfileController {
	private UserProfileService userProService;

	@Autowired
	public void setUserProfileService(UserProfileService userProService) {
		this.userProService = userProService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	List<UserProfile> findAllUserProfile(){
		return userProService.findAllUserProfile();	
	}
	
	@RequestMapping(value = "/delete/id={id}", method = RequestMethod.DELETE)
	@ResponseBody
	String deleteUserProfile(@PathVariable Integer id){
		String result = userProService.deleteUserProfile(id);
		if (result != null)
			return result;
		else return "failed";
	}
	
	@RequestMapping(value = "/id={id}", method = RequestMethod.GET)
	@ResponseBody
	UserProfile getUserProfileById(Integer Id){
		return userProService.getUserProfileById(Id);
	}	
}
