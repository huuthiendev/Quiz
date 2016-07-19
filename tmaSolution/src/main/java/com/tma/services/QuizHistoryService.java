package com.tma.services;

import java.util.List;

import com.tma.domain.QuizHistory;

public interface QuizHistoryService {	
	List<QuizHistory> listAllQuiz();
	
	QuizHistory getQuizHistoryById(Integer id);
	
	String deleteQuizHistory(Integer id);
}
