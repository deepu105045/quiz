package com.dvn.quiz.business.domain;

import java.util.Set;

public class QuestionOptions {
	private long questionId;
	private String questionText;
	private Set<String> options;
	
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public Set<String> getOptions() {
		return options;
	}
	public void setOptions(Set<String> options) {
		this.options = options;
	}

}
