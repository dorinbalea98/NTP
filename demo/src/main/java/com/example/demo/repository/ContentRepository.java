package com.example.demo.repository;

import com.example.demo.domain.Content;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContentRepository extends CrudRepository<Content, Long> {

    List<Content> findByParentId(final Long parentId);
}
