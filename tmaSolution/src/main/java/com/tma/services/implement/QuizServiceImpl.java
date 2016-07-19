package com.tma.services.implement;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.domain.Question;
import com.tma.domain.Quiz;
import com.tma.repositories.QuizRepository;
import com.tma.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	private QuizRepository quizRepository;
	
	@Autowired
	public void setQuizRepository(QuizRepository quizRepository){
		this.quizRepository = quizRepository;
	}
	
	@Override
	public Iterable<Quiz> listAllQuiz(){
		return quizRepository.findAll();
	}
	
	@Override
	public Quiz getQuizById(Integer id){
		return quizRepository.findOne(id);
	}
	
	@Override
	public Quiz saveQuiz(Quiz quiz){
		return quizRepository.save(quiz);
	}
	
	@Override
	public void delQuiz(Integer id){
		quizRepository.delete(id);
	}
	
	@Override
	public void updateQuiz(int id, String quizName, Short quizDuration, Set<Question> questions){
		Quiz quiz = quizRepository.findOne(id);
		quiz.setQuizName(quizName);
		quiz.setQuizDuration(quizDuration);
		
		quizRepository.save(quiz);
	}
}
