package com.tma.services;

import java.util.List;

import com.tma.domain.User;
import com.tma.domain.UserProfile;

public interface UserProfileService {
	List<UserProfile> findAllUserProfile();
	void deleteUserProfile(Integer Id);
	void addUserProfile(UserProfile userPro);
	UserProfile getUserProfileById(Integer Id);
	void save(UserProfile userProfile);
	boolean updateUserProfile(int id, int role, UserProfile userProfile);
}
