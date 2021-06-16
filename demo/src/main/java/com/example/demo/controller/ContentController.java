package com.example.demo.controller;

import com.example.demo.domain.Content;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("documents")
    public List<Content> getDocuments() {
        return contentService.getRoots();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("documents/{id}")
    public List<Content> getChildren(@PathVariable final Long id) {
        return contentService.getChildren(id);
    }
}
