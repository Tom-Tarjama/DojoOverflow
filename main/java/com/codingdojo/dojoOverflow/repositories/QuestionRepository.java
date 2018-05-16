package com.codingdojo.dojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

	Optional<Question> findByQuestion(String string);

}
