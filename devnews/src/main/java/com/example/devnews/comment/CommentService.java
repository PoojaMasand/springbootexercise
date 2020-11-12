package com.example.devnews.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    public List<Comment> getAll() {
        return repository.findAll();

    }

    public Optional<Comment> getCommentById(long id) {
        return repository.findById(id);
    }

    public Comment create(Comment newComment) {

        return repository.save(newComment);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Comment update(Comment updatedComment) {
        return repository.save(updatedComment);
    }

    public List<Comment> getAllByArticleId(long articleId) {
        return repository.findAllByArticleId(articleId);
    }
}