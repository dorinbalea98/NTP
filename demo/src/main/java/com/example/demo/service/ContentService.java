package com.example.demo.service;

import com.example.demo.domain.Content;
import com.example.demo.repository.ContentRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    @Cacheable(cacheNames = "children", key = "#id")
    public List<Content> getChildren(final Long id) {
        return repository.findByParentId(id);
    }

    @Cacheable(cacheNames = "roots")
    public List<Content> getRoots() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).filter(content -> Objects.isNull(content.getParentId())).collect(Collectors.toList());
    }
}
