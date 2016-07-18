package com.tma.services;

import com.tma.domain.Question;
import com.tma.domain.QuestionKind;

public interface QuestionService {
	Iterable<Question> listAllQuestions();
	
	Question getQuestionById(Integer id);
	
	Question saveQuestion(Question question);
	
	void delQuestion(Integer id);
	
	void updateQuestion(int id, String questionContent, String anwserRight, QuestionKind questionKind);
}
