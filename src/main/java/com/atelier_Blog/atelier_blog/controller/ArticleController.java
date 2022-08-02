package com.atelier_Blog.atelier_blog.controller;

import com.atelier_Blog.atelier_blog.dto.ArticleDto;
import com.atelier_Blog.atelier_blog.entity.Article;
import com.atelier_Blog.atelier_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping()
    public List<Article> getAll(){
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable Integer id){
        return articleService.getById(id);
       }

    @PostMapping()
    public Article postById(@RequestBody @Valid ArticleDto articleDto){
        return articleService.create(articleDto);
    }

    @PutMapping("/{id}")
    public Article updateById(@PathVariable Integer id, @RequestBody @Valid ArticleDto articleDto){
        return articleService.update(id, articleDto);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
         articleService.deleteById(id);
    }
}
