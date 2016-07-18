package com.tma.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tma.domain.Question;


public interface QuestionRepository extends CrudRepository<Question, Integer>{
}
