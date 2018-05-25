package com.dvn.quiz.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the options database table.
 * 
 */
@Entity
@Table(name="options")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int optionId;
	private boolean correctAnswer;
	private String optionText;

	public Option() {
	}

	public Option(boolean correctAnswer, String optionText) {
		super();
		this.correctAnswer = correctAnswer;
		this.optionText = optionText;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getOptionText() {
		return this.optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
}