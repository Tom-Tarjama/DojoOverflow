package com.codingdojo.dojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojoOverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	Optional<Tag> findById(Long id);

	Optional<Tag> findBySubject(String string);
}
