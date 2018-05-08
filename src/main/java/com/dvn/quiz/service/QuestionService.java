package com.dvn.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvn.quiz.models.Question;
import com.dvn.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		List<Question> questions = new ArrayList<>();
		questionRepository.findAll().forEach(questions::add);
		return questions;		
	}
	
//	public Question getQuestion(Long id) {
//		return questions.stream().filter(question -> question.getQuestionId().equals(id)).findFirst().get();
//	}
//
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}


}
