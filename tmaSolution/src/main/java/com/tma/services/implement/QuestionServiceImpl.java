package com.tma.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.domain.Question;
import com.tma.domain.QuestionKind;
import com.tma.repositories.QuestionRepository;
import com.tma.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	private QuestionRepository quesRepository;
	
	@Autowired
	public void setQuestionRepository(QuestionRepository questionRepository){
		this.quesRepository = questionRepository;
	}
	
	@Override
	public Iterable<Question> listAllQuestions(){
		return quesRepository.findAll();
	}
	
	@Override
	public Question getQuestionById(Integer id){
		return quesRepository.findOne(id);
	}
	
	@Override
	public Question saveQuestion(Question question){
		return quesRepository.save(question);
	}
	
	@Override
	public void delQuestion(Integer id){
		quesRepository.delete(id);
	}
	
	@Override
	public void updateQuestion(int id, String questionContent, String anwserRight, QuestionKind questionKind){
		Question ques = quesRepository.findOne(id);
		ques.setQuestionContent(questionContent);
		ques.setAnwserRight(anwserRight);
		ques.setQuestionKind(questionKind);
		
		quesRepository.save(ques);
	}
}
