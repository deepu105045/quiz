package com.dvn.quiz.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name= "questions", schema = "quiz")
public class Question{
	
//	@Id
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
//	@Column(name = "questionId", updatable = false, nullable = false)
//	private UUID questionId;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;

	private String questionText;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Option> options = new HashSet<>();
    
    private boolean isActive=true;

	public Question() {
		super();
	}

	public Question(Long questionId, String questionText, Set<Option> options, boolean isActive) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.options = options;
		this.isActive = isActive;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
