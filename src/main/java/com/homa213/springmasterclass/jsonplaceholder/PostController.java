package com.homa213.springmasterclass.jsonplaceholder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    private final PostClientApi postClientApi;

    public PostController(PostClientApi postClientApi) {
        this.postClientApi = postClientApi;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postClientApi.getposts();
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable("id") Long id) {
        return postClientApi.getPost(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postClientApi.createPost(post);
    }

    @PutMapping("{id}")
    public  Post updatePost(@RequestBody Post post, @PathVariable("id") Long id){
        return postClientApi.updatePost(post, id);
    }
}
