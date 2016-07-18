package com.tma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question_kind")
public class QuestionKind {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "kind_name", unique = true)
	private String kindName;
	
	QuestionKind(){}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	};
	
	
	
}
