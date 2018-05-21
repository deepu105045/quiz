package com.dvn.quiz.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="options", schema = "quiz")
public class Option {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long optionId;
	
	private String optionText;
	private boolean correctAnswer=false;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionId")
	private Question question;

	public Option() {
	}

	public Option(Long optionId, String optionText, boolean correctAnswer, Question question) {
		super();
		this.optionId = optionId;
		this.optionText = optionText;
		this.correctAnswer = correctAnswer;
		this.question = question;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
