package com.tma.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tma.domain.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>{

}
