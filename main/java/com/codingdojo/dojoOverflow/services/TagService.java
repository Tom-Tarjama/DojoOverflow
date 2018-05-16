package com.codingdojo.dojoOverflow.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.models.Tag;
import com.codingdojo.dojoOverflow.repositories.TagRepository;

@Service
public class TagService {
    //We want to use our repository as a vriable within this service, as follows:
    private TagRepository tagRepository;

  //Create construtor to instantiate for use in service
	  public TagService(TagRepository tagRepository){
	        this.tagRepository = tagRepository;
	    }
	  
	    public Tag createTag(Tag tag){
	        return tagRepository.save(tag);
	    }
	    
		  public void updateTag(Tag tag) {
			  tagRepository.save(tag);
		  }
	    
	    public Tag findTagById(Long id) {
		    Optional<Tag> optionalTag = tagRepository.findById(id);
		    if(optionalTag.isPresent()) {
		        return optionalTag.get();
		    } else {
		        return null;
		    }
		}
	    
	    public Tag findOne(String string) {
		    Optional<Tag> optionalTag = tagRepository.findBySubject(string);
		    if(optionalTag.isPresent()) {
		        return optionalTag.get();
		    } else {
		        return null;
		    }
		}
}
