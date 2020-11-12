package com.example.devnews.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService service;

    @GetMapping("")
    public List<Article> getAll(@RequestParam(required = false) Long topicsId)
    {
        if(topicsId == null )
            return service.getAll();
        else
            return service.getArticleByTopicId(topicsId);
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id)
    {
        return service.getArticleById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Article create(@RequestBody Article newArticle)
    {
        return service.create(newArticle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)
    {
        service.delete(id);
    }

    @PutMapping("")
    public Article update(@RequestBody Article updatedArticle)
    {
        return service.update(updatedArticle);
    }

}
