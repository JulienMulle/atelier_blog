package com.atelier_Blog.atelier_blog.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ArticleDto {
    @NotEmpty(message = "le titre est requis")
    @Size(min=5, max=150)
    private String title;
    @NotEmpty(message="le contenu est requis")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
