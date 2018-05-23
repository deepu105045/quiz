package com.dvn.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvn.quiz.models.Option;

public interface OptionRepository extends JpaRepository<Option, Long>{

}
