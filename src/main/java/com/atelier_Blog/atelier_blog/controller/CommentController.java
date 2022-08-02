package com.atelier_Blog.atelier_blog.controller;

import com.atelier_Blog.atelier_blog.dto.CommentDto;
import com.atelier_Blog.atelier_blog.entity.Comment;
import com.atelier_Blog.atelier_blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articles/{id}/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllCommentsByArticle(@PathVariable int id){
        return commentService.getCommentsByIdArticle(id);
    }

    @PostMapping
    public Comment createCommentByArticle(@PathVariable Integer id, @RequestBody CommentDto commentDto){
        return commentService.createCommentByIdArticle(id, commentDto);
    }

    @PutMapping("/{idcomment}")
    public Comment updateCommentByArticle (@PathVariable int id, @PathVariable int idcomment, @RequestBody @Valid CommentDto commentDto){
        return commentService.updateCommentById(idcomment,commentDto);
    }

    @DeleteMapping("/{idComment}")
    public void deleteById(@PathVariable int idComment ) {
        commentService.deleteById(idComment);

    }
}
