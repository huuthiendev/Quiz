package com.tma.services;

import java.util.List;

import com.tma.domain.UserProfile;

public interface UserProfileService {
	List<UserProfile> findAllUserProfile();
	String deleteUserProfile(Integer Id);
	void addUserProfile(UserProfile userPro);
	UserProfile getUserProfileById(Integer Id);
	boolean updateUserProfile(int id, int role, UserProfile userProfile);
}
