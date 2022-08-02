package com.atelier_Blog.atelier_blog.service;

import com.atelier_Blog.atelier_blog.dto.CommentDto;
import com.atelier_Blog.atelier_blog.entity.Article;
import com.atelier_Blog.atelier_blog.entity.Comment;
import com.atelier_Blog.atelier_blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ArticleService articleService;

    public List<Comment> getCommentsByIdArticle(int id){
        Article article = articleService.getById(id);
        return article.getComments();
    }

    public Comment createCommentByIdArticle(Integer id, CommentDto commentDto) {
        //Comment comment = new Comment(commentDto.getContent(), article); voir commentaire dans entity/comment
        Article article = articleService.getById(id);
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setArticle(article);
        return commentRepository.save(comment);
    }

    public Comment updateCommentById(int idcomment, CommentDto commentDto) {
        Comment comment = commentRepository.findById(idcomment).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        //Comment comment = new Comment(commentDto.getContent(), article); voir commentaire dans entity/comment
        comment.setContent(commentDto.getContent());
        return commentRepository.save(comment);
    }

    public void deleteById(int idComment) {
        try {
            commentRepository.deleteById(idComment);
        } catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
