package com.dvn.quiz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvn.quiz.models.Option;

@Repository
public interface OptionRepository extends CrudRepository<Option,Long>{

}
