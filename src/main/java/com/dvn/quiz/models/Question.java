package com.dvn.quiz.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question{

	private Long questionId;
	private String questionText;
	private List<Option> option;
	
	public Question() {
	}
	
	public Question(Long questionId, String questionText ,List<Option> option) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.option = option;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

	@OneToMany(targetEntity=Option.class , mappedBy = "question", cascade = CascadeType.ALL ,fetch = FetchType.LAZY )
	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", options=" + option + "]";
	}
	
}
