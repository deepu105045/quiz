package com.dvn.quiz.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name = "questions")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long questionId;
	private String author;
	private boolean expired;
	private String questionText;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "questionId")
	private Set<Option> options = new HashSet<>();

	public Question() {
	}

	public Question(String author, boolean expired, String questionText, Set<Option> options) {
		this.author = author;
		this.expired = expired;
		this.questionText = questionText;
		this.options = options;
	}

	public long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public String getQuestionText() {
		return this.questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Set<Option> getOptions() {
		return this.options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

}