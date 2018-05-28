package com.dvn.quiz.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvn.quiz.business.domain.QuestionAnswers;
import com.dvn.quiz.business.domain.QuestionOptions;
import com.dvn.quiz.entity.Option;
import com.dvn.quiz.entity.Question;
import com.dvn.quiz.repository.QuestionRepository;



@Service
public class QuestionService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	private QuestionRepository questionRepository;

	public List<QuestionOptions> getAllQuestions() {	
		
		List<QuestionOptions> questionOptions = new ArrayList<>();
		questionRepository.findAll()
						  .forEach(dbQuestion -> {
								QuestionOptions qo= new QuestionOptions();
								Set<String> options = new HashSet<>();
								
								qo.setQuestionId(dbQuestion.getQuestionId());
								qo.setQuestionText(dbQuestion.getQuestionText());
								Set<Option> dbOptions = dbQuestion.getOptions();
								dbOptions.forEach(dbOption ->{options.add(dbOption.getOptionText());});
								qo.setOptions(options);
								questionOptions.add(qo);
		});
		return questionOptions;
		
	}
	
	public QuestionOptions getQuestion(Long id) {
		Question  dbQuestion= questionRepository.findOne(id);
		Set<String> options = new HashSet<>();
		
		QuestionOptions qo= new QuestionOptions();
		qo.setQuestionId(dbQuestion.getQuestionId());
		qo.setQuestionText(dbQuestion.getQuestionText());
		dbQuestion.getOptions().forEach(dbOption -> options.add(dbOption.getOptionText()));
		qo.setOptions(options);
		return qo;
	}

	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	public Question updateQuestion(long id, Question question) {

		Question  oldQuestion= questionRepository.findOne(id);
		if(oldQuestion != null) {
			return questionRepository.save(question);
		}else {
			logger.info("Question not present in the databse : " + question.toString());
			return null;
		}
	}
	
	public QuestionAnswers getAnswer(long questionId) {
		Question  question= questionRepository.findOne(questionId);
		QuestionAnswers questionAnswers = new QuestionAnswers();
		StringBuilder sb = new StringBuilder();
		int i=0;
		
		List<Option> correctAnswers = question.getOptions().stream().filter(option -> option.isCorrectAnswer()).collect(Collectors.toList());
		questionAnswers.setQuestionText(question.getQuestionText());
		for(Option ans : correctAnswers) {
			sb.append(ans.getOptionText()) ;
			if(correctAnswers.size()!=++i) {
				sb.append(",");
			}
		}
		questionAnswers.setAnswers(sb.toString());
		return questionAnswers;
	}
	
	public Question deactivateQuestion(Long questionId) {
		Question  question= questionRepository.findOne(questionId);
		question.setExpired(true);
		return questionRepository.save(question);
	}

}
