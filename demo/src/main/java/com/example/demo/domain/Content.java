package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Content {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String title;
    private ContentType type;
    private String mymeType;
    private String url;
    private Long parentId;

    public Content() {}

    public Content(String name, String title, ContentType type, String mymeType, String url, Long parentId) {
        this.name = name;
        this.title = title;
        this.type = type;
        this.mymeType = mymeType;
        this.url = url;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }

    public String getMymeType() {
        return mymeType;
    }

    public void setMymeType(String mymeType) {
        this.mymeType = mymeType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
