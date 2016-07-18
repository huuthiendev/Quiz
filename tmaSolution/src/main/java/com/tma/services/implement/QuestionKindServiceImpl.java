package com.tma.services.implement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.domain.QuestionKind;
import com.tma.repositories.QuestionKindRepository;
import com.tma.services.QuestionKindService;


@Service
public class QuestionKindServiceImpl implements QuestionKindService {
	private QuestionKindRepository queskRepository;
	
	@Autowired
	public void setQuestionKindRepository(QuestionKindRepository quesKRepository){
		this.queskRepository = quesKRepository;
	}
	
	@Override
	public Iterable<QuestionKind> listAllQuesKind(){
		return queskRepository.findAll();
	}
	
	@Override
	public QuestionKind getQuesKindById(Integer id){
		return queskRepository.findOne(id);
	}
	
	@Override
	public QuestionKind saveQuesKind(QuestionKind quesKind){
		return queskRepository.save(quesKind);
	}
	
	@Override
	public void delQuesKind(Integer id){
		queskRepository.delete(id);
	}
	
	@Override
	public void updateQuesKind(int id, String kindName){
		QuestionKind quesK = queskRepository.findOne(id);
		quesK.setKindName(kindName);
	}
}
