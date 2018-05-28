package com.dvn.quiz.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dvn.quiz.business.domain.QuestionAnswers;
import com.dvn.quiz.business.domain.QuestionOptions;
import com.dvn.quiz.entity.Question;
import com.dvn.quiz.service.QuestionService;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionService questionService;
	
	@GetMapping
	@RequestMapping("/questions")
	public ResponseEntity<List<QuestionOptions>> list(){
		List<QuestionOptions> questions = questionService.getAllQuestions();
		return new ResponseEntity<List<QuestionOptions>>(questions,HttpStatus.OK);		
	}
	
	@GetMapping
	@RequestMapping(method = RequestMethod.GET, value="/questions/{id}")
	public ResponseEntity<QuestionOptions> getQuestion(@PathVariable long id) {
		return new ResponseEntity<QuestionOptions>(questionService.getQuestion(id),HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(method = RequestMethod.GET, value="/questions/{id}/answer")
	public ResponseEntity<QuestionAnswers> getAnswer(@PathVariable long id) {
		return new ResponseEntity<QuestionAnswers>( questionService.getAnswer(id),HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value= "/questions")
	@Transactional
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		logger.info("Request recieved from client : " + question.toString());
		return new ResponseEntity<Question>(questionService.addQuestion(question),HttpStatus.OK);
	}

	@PutMapping
	@RequestMapping(method = RequestMethod.PUT, value="/questions/{id}")
	@Transactional
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question ,@PathVariable long id) {
		return new ResponseEntity<Question>(questionService.updateQuestion(id,question),HttpStatus.OK);
	}
	
	@PutMapping
	@Transactional
	@RequestMapping(method = RequestMethod.PUT, value="/questions/{id}/deactivate")
	public ResponseEntity<Question> deactivateQuestion(@PathVariable long id){
		return new ResponseEntity<Question>(questionService.deactivateQuestion(id), HttpStatus.OK);
	}
	
}
