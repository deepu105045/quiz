package com.dvn.quiz.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "questions", schema = "quiz")
public class Question{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;

	private String questionText;
	
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Option> options = new HashSet<>();

	public Question() {
		super();
	}

	public Question(Long questionId, String questionText, Set<Option> options) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.options = options;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	

	
}
