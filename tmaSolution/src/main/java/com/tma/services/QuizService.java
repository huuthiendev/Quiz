package com.tma.services;


import java.util.Set;

import com.tma.domain.Question;
import com.tma.domain.Quiz;

public interface QuizService {
	Iterable<Quiz> listAllQuiz();
	
	Quiz getQuizById(Integer id);
	
	Quiz saveQuiz(Quiz quiz);
	
	void delQuiz(Integer id);
	
	void updateQuiz(int id, String quizName, Short quizDuration, Set<Question> questions);
}
