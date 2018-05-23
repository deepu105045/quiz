package com.dvn.quiz.models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;

	private String author;

	private boolean expired;

	private String questionText;

	//bi-directional many-to-one association to Option
	
	@OneToMany( mappedBy="question",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Option> options = new HashSet<>();

	public Question() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
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

	public Option addOption(Option option) {
		getOptions().add(option);
		option.setQuestion(this);
		return option;
	}

	public Option removeOption(Option option) {
		getOptions().remove(option);
		option.setQuestion(null);
		return option;
	}

}