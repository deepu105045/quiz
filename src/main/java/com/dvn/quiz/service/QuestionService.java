package com.dvn.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvn.quiz.models.Question;
import com.dvn.quiz.repository.QuestionRepository;


@Service
public class QuestionService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		List<Question> questions = new ArrayList<>();
		questionRepository.findAll().forEach(questions::add);
		return questions;		
	}
	
	public Question getQuestion(Long id) {
		return questionRepository.findOne(id);
	}

	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	public Question updateQuestion(long id, Question question) {
		Question oldQuestion=getQuestion(id);
		if(oldQuestion != null) {
			return questionRepository.save(question);
		}else {
			logger.info("Question not present in the databse : " + question.toString());
			return null;
		}
	}
	
	public void deactivateQuestion(Long questionId) {
		Question question=getQuestion(questionId);
		question.setActive(false);
		questionRepository.save(question);
	}

}
