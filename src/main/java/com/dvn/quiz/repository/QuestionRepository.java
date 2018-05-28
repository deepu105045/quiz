package com.dvn.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvn.quiz.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

}
