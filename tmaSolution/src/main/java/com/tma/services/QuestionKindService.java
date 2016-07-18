package com.tma.services;

import com.tma.domain.QuestionKind;

public interface QuestionKindService {
	Iterable<QuestionKind> listAllQuesKind();
	
	QuestionKind getQuesKindById(Integer id);
	
	QuestionKind saveQuesKind(QuestionKind quesKind);
	
	void delQuesKind(Integer id);
	
	void updateQuesKind(int id, String kindName);
}
