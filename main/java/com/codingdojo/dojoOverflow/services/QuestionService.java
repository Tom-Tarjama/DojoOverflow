package com.codingdojo.dojoOverflow.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.models.Tag;
import com.codingdojo.dojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

    //We want to use our repository as a vriable within this service, as follows:
    private QuestionRepository questionRepository;

  //Create construtor to instantiate for use in service
	  public QuestionService(QuestionRepository questionRepository){
	        this.questionRepository = questionRepository;
	    }
	  
	  public ArrayList<Question> allQuestions(){
		  return (ArrayList<Question>) questionRepository.findAll();
	  }
	  
	  public Question createQuestion(Question question){
	      return questionRepository.save(question);
	  }
	  
	  public void updateQuestion(Question question) {
		  questionRepository.save(question);
	  }
	  
	    public Question findOne(String string) {
		    Optional<Question> optionalQuestion = questionRepository.findByQuestion(string);
		    if(optionalQuestion.isPresent()) {
		        return optionalQuestion.get();
		    } else {
		        return null;
		    }
		}
	  

}
