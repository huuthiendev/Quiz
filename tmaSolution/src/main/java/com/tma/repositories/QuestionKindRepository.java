package com.tma.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tma.domain.QuestionKind;


public interface QuestionKindRepository extends CrudRepository<QuestionKind, Integer> {
}
