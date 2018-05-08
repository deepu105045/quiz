package com.dvn.quiz.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dvn.quiz.models.Question;
import com.dvn.quiz.service.QuestionService;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionService questionService;
	
	@GetMapping
	@RequestMapping("/questions")
	public List<Question> list(){
		return questionService.getAllQuestions();
	}
	
//	@GetMapping
//	@RequestMapping("/question/{id}")
//	public Question getQuestion(@PathVariable long id) {
//		return questionService.getQuestion(id);
//	}
//	
	@RequestMapping(method = RequestMethod.POST, value= "/questions")
	public void addQuestion(@RequestBody Question question) {
		logger.info("Request recieved from client : " + question.toString());
		questionService.addQuestion(question);
	}
//	
//	@RequestMapping(method = RequestMethod.PUT, value="/questions/{id}")
//	public void updateQuestion(@RequestBody Question question ,@PathVariable long id) {
//		questionService.updateQuestion(id, question);
//	}

}
