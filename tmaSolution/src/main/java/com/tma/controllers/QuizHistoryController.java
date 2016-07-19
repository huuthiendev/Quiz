package com.tma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.domain.QuizHistory;
import com.tma.services.QuizHistoryService;

@Controller
@RequestMapping("/quiz-history")
public class QuizHistoryController {
	
	private QuizHistoryService qHistoryS;
	
	@Autowired
	public void setqHistoryS(QuizHistoryService qHistoryS) {
		this.qHistoryS = qHistoryS;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	List<QuizHistory> quizHistoryList(){
		return qHistoryS.listAllQuiz();
	}
	
	@RequestMapping(value = "/id={id}", method = RequestMethod.DELETE)
	@ResponseBody
	String deleteQuizHistory(@PathVariable("id") int id){
		return qHistoryS.deleteQuizHistory(id);
	}
	
	@RequestMapping(value = "/id={id}", method = RequestMethod.GET)
	@ResponseBody
	QuizHistory findQuizHistory(@PathVariable("id") int id){
		return qHistoryS.getQuizHistoryById(id);
	}
}
