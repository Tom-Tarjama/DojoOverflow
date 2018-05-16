package com.codingdojo.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojoOverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

}
