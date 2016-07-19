package com.tma.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tma.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("SELECT u FROM User u Where u.name=:user and u.passwordHash=:pass")
	public User checkLogin(@Param("user") String user, @Param("pass") String pass);
}
