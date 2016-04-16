/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.controllers;

import static com.slavasokolov.employeemanager.controllers.PostRestController.POSTS_PATH;
import com.slavasokolov.employeemanager.entities.Post;
import com.slavasokolov.employeemanager.repositories.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ֲÿקוסכאג
 */
@RestController
@RequestMapping(path = POSTS_PATH,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PostRestController {

    public static final String POSTS_PATH = "/posts";
    public static final String ITEM_PATH = "/item";

    private PostRepository postRepository;

    @Autowired(required = false)
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getPostList() {
        return postRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Post createPost(@RequestBody Post post) {
        return postRepository.create(post);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Post updatePost(@RequestBody Post post) {
        return postRepository.update(post);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deletePost(@RequestBody Post post) {
        postRepository.delete(post);
    }

}
