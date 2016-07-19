package com.tma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.domain.Question;
import com.tma.domain.QuestionKind;
import com.tma.services.QuestionService;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {

	private QuestionService questSer;
	
	@Autowired
	public void setquestSer(QuestionService questSer){
		this.questSer= questSer;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Question> listQuestion() {
		return questSer.listAllQuestions();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Question findQuestion(@PathVariable int id){
		return questSer.getQuestionById(id);
	}
	//delete
	@RequestMapping(value ="/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteQuestion(@PathVariable int id){
		questSer.delQuestion(id);
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	@ResponseBody
	public void saveQuestion(Question question){
		questSer.saveQuestion(question);
	}
	
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	@ResponseBody
	public void updateQuestion(
			@RequestParam("id") int id,
			@RequestParam("questionContent") String questCon,
			@RequestParam("anwserRight") String answerR,
			@RequestParam("questionKind") QuestionKind questKind
			){
		questSer.updateQuestion(id, questCon, answerR, questKind);
	}
	
}
