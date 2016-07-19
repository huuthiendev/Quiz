package com.tma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.domain.QuestionKind;
import com.tma.services.QuestionKindService;

@Controller
@RequestMapping(value = "/question_kind")
public class QuestionKindController {

	private QuestionKindService questSer;
	
	@Autowired
	public void setquestSer(QuestionKindService questSer){
		this.questSer= questSer;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<QuestionKind> listQuestion() {
		return questSer.listAllQuesKind();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public QuestionKind findQuestion(@PathVariable int id){
		return questSer.getQuesKindById(id);
	}
	//delete
	@RequestMapping(value ="/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteQuestion(@PathVariable int id){
		questSer.delQuesKind(id);
	}
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	@ResponseBody
	public void saveQuestion(QuestionKind question){
		questSer.saveQuesKind(question);
	}
	
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	@ResponseBody
	public void updateUser(
			@RequestParam("id") int id,
			@RequestParam("kindName") String kindName
			){
		questSer.updateQuesKind(id, kindName);
	}
	
}
