package com.example.devnews.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository repository;

    public List<Article> getAll()
    {
        return repository.findAll();

    }

    public Optional<Article> getArticleById(long id)
    {
        return repository.findById(id);
    }

    public Article create(Article newArticle) {

        return repository.save(newArticle);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Article update(Article updatedArticle) {
        return repository.save(updatedArticle);
    }

    public List<Article> getArticleByTopicId(Long topicsId) {
        return repository.getAllByTopics_Id(topicsId);
    }
}
