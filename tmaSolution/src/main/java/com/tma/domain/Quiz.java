package com.tma.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Quiz")
public class Quiz {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int	id;
	
	@OneToMany
	@JoinColumn(name = "question_id")
	private Set<Question> questions = new HashSet<Question>(0);
	
	@Column(name = "quiz_name", unique = true)
	private String quizName;
	
	@Column(name = "quiz_duration")
	private Short quizDuration;
	
	@Column(name = "quiz_start_time")
	private Timestamp quizStartTime;
	
	@Column(name = "quiz_end_time")
	private Timestamp quizEndTime;
	
	@Column(name = "quanity_run")
	private Short quanityRun;
	
	@Column(name = "deleted_flag")
	private boolean deletedFlag;
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "updated_by")
	private int updatedBy;
	
	@Column(name = "created_At")
	private Timestamp createdAt;
	
	@Column(name = "updated_At")
	private Timestamp updatedAt;
	
	public Quiz(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public Short getQuizDuration() {
		return quizDuration;
	}

	public void setQuizDuration(Short quizDuration) {
		this.quizDuration = quizDuration;
	}

	public Timestamp getQuizStartTime() {
		return quizStartTime;
	}

	public void setQuizStartTime(Timestamp quizStartTime) {
		this.quizStartTime = quizStartTime;
	}

	public Timestamp getQuizEndTime() {
		return quizEndTime;
	}

	public void setQuizEndTime(Timestamp quizEndTime) {
		this.quizEndTime = quizEndTime;
	}

	public Short getQuanityRun() {
		return quanityRun;
	}

	public void setQuanityRun(Short quanityRun) {
		this.quanityRun = quanityRun;
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
	
	
}