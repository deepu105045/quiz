package com.dvn.quiz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvn.quiz.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{

}
