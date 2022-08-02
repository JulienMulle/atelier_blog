package com.atelier_Blog.atelier_blog.repository;

import com.atelier_Blog.atelier_blog.entity.Article;
import com.atelier_Blog.atelier_blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment>findByArticle(Article article);
}
