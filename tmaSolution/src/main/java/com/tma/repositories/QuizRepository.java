package com.tma.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tma.domain.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {
}
