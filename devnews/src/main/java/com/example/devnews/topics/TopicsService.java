package com.example.devnews.topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {
    @Autowired
    TopicsRepository repository;

    public List<Topics> getAll() {
        return repository.findAll();

    }

    public Optional<Topics> getTopicsById(long id) {
        return repository.findById(id);
    }

    public Topics create(Topics newTopics) {

        return repository.save(newTopics);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Topics update(Topics updatedTopics) {
        return repository.save(updatedTopics);
    }

    public List<Topics> getAllByArticleId(Long articleId) {
        return repository.getAllByArticles_Id(articleId);
    }
}
