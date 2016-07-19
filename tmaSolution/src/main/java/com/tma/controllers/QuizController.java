package com.tma.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.domain.Question;
import com.tma.domain.Quiz;
import com.tma.services.QuizService;

@Controller
@RequestMapping(value = "/quiz")
public class QuizController {

	private QuizService quizSer;
	
	@Autowired
	public void setquizSer(QuizService quizSer){
		this.quizSer= quizSer;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Quiz> listQuiz() {
		return quizSer.listAllQuiz();
	}
	
	@RequestMapping(value = "/id={id}", method = RequestMethod.GET)
	@ResponseBody
	public Quiz findQuiz(@PathVariable int id){
		return quizSer.getQuizById(id);
	}
	//delete
	@RequestMapping(value ="/id={id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuiz(@PathVariable int id){
		quizSer.delQuiz(id);
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	@ResponseBody
	public void saveQuiz(Quiz quiz){
		quizSer.saveQuiz(quiz);
	}
	
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	@ResponseBody
	public void updateQuiz(
			@RequestParam("id") int id,
			@RequestParam("quizName") String quizName,
			@RequestParam("quizDuration") Short quizDu,
			@RequestParam("questions") Set<Question> questions
			){
		quizSer.updateQuiz(id, quizName, quizDu, questions);
	}
	
}
