package com.example.devnews.topics;

import com.example.devnews.comment.Comment;
import com.example.devnews.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsController {
    @Autowired

    TopicsService service;

    @GetMapping("")
    public List<Topics> getAll(@RequestParam(required = false) Long articleId)
    {
            if(articleId==null)
                return service.getAll();
            else
                return service.getAllByArticleId(articleId);

    }

    @GetMapping("/{id}")
    public Topics getTopicsById(@PathVariable long id)
    {
        return service.getTopicsById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



    @PostMapping("")
    public Topics create(@RequestBody Topics newTopics)
    {
        return service.create(newTopics);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)
    {
        service.delete(id);
    }

    @PutMapping("")
    public Topics update(@RequestBody Topics updatedTopics)
    {
        return service.update(updatedTopics);
    }
}
