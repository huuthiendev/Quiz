package com.tma.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.tma.domain.UserProfile;
import com.tma.repositories.UserProfileRepository;
import com.tma.services.UserProfileService;
import com.tma.tool.WebTool;

@Service
public class UserProfileImp implements UserProfileService{

	private UserProfileRepository userProfileRepo;
	@Override
	public List<UserProfile> findAllUserProfile() {
		return Lists.newArrayList(userProfileRepo.findAll());
	}

	@Override
	public String deleteUserProfile(Integer Id) {
		UserProfile userP = userProfileRepo.findOne(Id);
		if (userP != null)
		{
			userProfileRepo.delete(Id);
			return userP.getUser().getName() + "'s profile is deleted";
		}
		else return null;
	}

	@Override
	public boolean updateUserProfile(int id, int role, UserProfile userProfile) {
		UserProfile userP = userProfileRepo.findOne(id);
		
		if(userP == null)
			return false;
		
		userP.setFirstName(userProfile.getFirstName());
		userP.setLastName(userProfile.getLastName());
		userP.setFullName(userProfile.getFullName());
		userP.setEmail(userProfile.getEmail());
		userP.setUpdatedAt(WebTool.getTime());
		userP.setUpdatedBy(role);
		
		userProfileRepo.save(userP);
		
		return true;
	}

	@Override
	public void addUserProfile(UserProfile userPro) {
		userProfileRepo.save(userPro);
	}

	@Override
	public UserProfile getUserProfileById(Integer Id) {
		return userProfileRepo.findOne(Id);
	}

}
