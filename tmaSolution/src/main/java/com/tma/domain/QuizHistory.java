package com.tma.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_history")
public class QuizHistory {
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<User> users = new HashSet<User>(0);
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@Column(name = "score")
	private Short score;
	@Column(name = "duration")
	private Short duration;
	
	public QuizHistory(){}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Short getScore() {
		return score;
	}

	public void setScore(Short score) {
		this.score = score;
	}

	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
		this.duration = duration;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	
}