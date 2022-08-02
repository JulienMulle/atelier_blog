package com.atelier_Blog.atelier_blog.service;

import com.atelier_Blog.atelier_blog.dto.ArticleDto;
import com.atelier_Blog.atelier_blog.entity.Article;
import com.atelier_Blog.atelier_blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article create(ArticleDto articleDto){
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        return articleRepository.save(article);
    }

    public  Article getById(int id){
        //        Optional<Article> optionnalArticle = articleRepository.findById(id);
//        if (optionnalArticle.isPresent())return  optionnalArticle.get();
//        return null;
//        Optional<Article> optionalArticle = articleRepository.findById(id);
//        return optionalArticle.orElseThrow(
//                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
//        );
        return  articleRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Article update(int id, ArticleDto articleDto){
        Article articleToUpdate = articleRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        articleToUpdate.setTitle(articleDto.getTitle());
        articleToUpdate.setContent(articleDto.getContent());
        return articleRepository.save(articleToUpdate);
    }

    public void deleteById(int id){
        try {
            articleRepository.deleteById(id);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
