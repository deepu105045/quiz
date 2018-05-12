package com.dvn.quiz.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<Question>> list(){
		List<Question> questions = questionService.getAllQuestions();
		return new ResponseEntity<List<Question>>(questions,HttpStatus.OK);		
	}
	
	@GetMapping
	@RequestMapping(method = RequestMethod.GET, value="/questions/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable long id) {
		return new ResponseEntity<Question>(questionService.getQuestion(id),HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value= "/questions")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		logger.info("Request recieved from client : " + question.toString());
		return new ResponseEntity<Question>(questionService.addQuestion(question),HttpStatus.OK);
	}

	@PutMapping
	@RequestMapping(method = RequestMethod.PUT, value="/questions/{id}")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question ,@PathVariable long id) {
		return new ResponseEntity<Question>(questionService.updateQuestion(id,question),HttpStatus.OK);
	}
	
}
