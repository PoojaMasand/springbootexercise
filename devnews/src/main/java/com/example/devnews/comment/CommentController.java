package com.example.devnews.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired

    CommentService service;

    @GetMapping("")
    public List<Comment> getAll(@RequestParam(required = false) Long articleId)
    {
        if(articleId == null)
            return service.getAll();
        else
            return service.getAllByArticleId(articleId);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable long id)
    {
        return service.getCommentById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



    @PostMapping("")
    public Comment create(@RequestBody Comment newComment)
    {
        return service.create(newComment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)
    {
        service.delete(id);
    }

    @PutMapping("")
    public Comment update(@RequestBody Comment updatedComment)
    {
        return service.update(updatedComment);
    }
}
