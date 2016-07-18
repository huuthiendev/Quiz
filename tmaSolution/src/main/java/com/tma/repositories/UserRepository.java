package com.tma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tma.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
