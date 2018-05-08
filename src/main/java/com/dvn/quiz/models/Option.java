package com.dvn.quiz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Option {

	private Long optionId;
    private String optionText;
    private Question question;
    
	public Option() {
	}    
    
	public Option(Long optionId, String optionText, Question question) {
		super();
		this.optionId = optionId;
		this.optionText = optionText;
		this.question = question;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	
    @ManyToOne
    @JoinColumn(name = "question")
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


    

}
