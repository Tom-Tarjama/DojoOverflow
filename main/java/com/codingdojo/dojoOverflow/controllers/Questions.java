package com.codingdojo.dojoOverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.models.Tag;
import com.codingdojo.dojoOverflow.services.QuestionService;
import com.codingdojo.dojoOverflow.services.TagService;

@Controller
public class Questions {
	
	private QuestionService questionService;
	private TagService tagService;

    //Create construtor to instantiate for use in class

 public Questions(QuestionService questionService, TagService tagService) {
	this.questionService = questionService;
	this.tagService = tagService;
}
	
	@RequestMapping("/questions")
	public String index(Model model) {
		model.addAttribute("questions", questionService.allQuestions());
		return "index.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(Model model) {
		model.addAttribute("query", new Question());
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(@Valid @ModelAttribute("query") Question question, @RequestParam("input_tags") String input_tags, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("TEST");
			return "newQuestion.jsp";
		}
		else {
			Question myQuestion = questionService.findOne(question.getQuestion());
			if(myQuestion == null) {
				questionService.createQuestion(question);
				myQuestion = questionService.findOne(question.getQuestion());
			}
			
			ArrayList<String> splitTags = new ArrayList<String>(Arrays.asList(input_tags.toLowerCase().split(",")));
			System.out.println("BEFORE "+input_tags);
			System.out.println("AFTER "+splitTags);
			List<Tag> findTags = myQuestion.getTags();
			
			
			for(int i = 0; i <splitTags.size(); i++) {
				String myString = splitTags.get(i);
				Tag myTag = tagService.findOne(myString);
				if(myTag == null) {	
				myTag = new Tag(myString);
				tagService.createTag(myTag);
				}

				if(!myQuestion.getTags().contains(myTag)) {
					findTags.add(myTag);
				}

				myQuestion.setTags(findTags);
		
				questionService.updateQuestion(myQuestion);
		
			}
			
			return "redirect:/questions";
		}
	}
}
