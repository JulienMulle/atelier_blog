package com.atelier_Blog.atelier_blog.repository;

import com.atelier_Blog.atelier_blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
