package com.tma.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.tma.domain.QuizHistory;
import com.tma.repositories.QuizHistoryRepository;
import com.tma.services.QuizHistoryService;

@Service
public class QuizHistoryImp implements QuizHistoryService{

	private QuizHistoryRepository qHistoryRepo;
	
	@Autowired
	public void setQuizHistoryRepo(QuizHistoryRepository qHistoryRepo) {
		this.qHistoryRepo = qHistoryRepo;
	}
	
	@Override
	public List<QuizHistory> listAllQuiz() {
		return Lists.newArrayList(qHistoryRepo.findAll());
	}
	

	@Override
	public QuizHistory getQuizHistoryById(Integer id) {
		return qHistoryRepo.findOne(id);
	}

	@Override
	public String deleteQuizHistory(Integer id) {
		QuizHistory qH = qHistoryRepo.findOne(id);
		if (qH != null){
			qHistoryRepo.delete(id);
			return "Deleted";
		}
		else return "Cannot Delete";
	}

}
