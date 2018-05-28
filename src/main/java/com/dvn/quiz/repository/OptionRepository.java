package com.dvn.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvn.quiz.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Long>{
	
}
