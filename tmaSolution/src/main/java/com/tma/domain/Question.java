package com.tma.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION")
public class Question {
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "question_content")
	private String questionContent;
	
	@ManyToOne
	@JoinColumn(name = "question_kind", referencedColumnName = "kind_name")
	private QuestionKind questionKind;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@Column(name = "anwser_content")
	private String anwserContent;
	
	@Column(name = "anwser_right")
	private String anwserRight;
	
	@Column(name = "deleted_flag")
	private boolean deletedFlag;
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "updated_by")
	private int updatedBy;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	public Question(){}
	
	public int getId() {
		return id;
	}
	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getAnwserContent() {
		return anwserContent;
	}

	public void setAnwserContent(String anwserContent) {
		this.anwserContent = anwserContent;
	}

	public String getAnwserRight() {
		return anwserRight;
	}

	public void setAnwserRight(String anwserRight) {
		this.anwserRight = anwserRight;
	}

	public boolean isDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public QuestionKind getQuestionKind() {
		return questionKind;
	}

	public void setQuestionKind(QuestionKind questionKind) {
		this.questionKind = questionKind;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	
}
