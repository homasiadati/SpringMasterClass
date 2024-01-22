package com.homa213.springmasterclass.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com/posts", name = "postClient")
public interface PostClientApi {

    @GetMapping()
    List<Post> getposts();

    @GetMapping("{id}")
    Post getPost(@PathVariable("id") Long id);

    @PostMapping
    Post createPost(@RequestBody Post post);

    @PutMapping("{id}")
    Post updatePost(@RequestBody Post post, @PathVariable("id") Long id);
}
