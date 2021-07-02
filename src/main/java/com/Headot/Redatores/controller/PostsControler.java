package com.Headot.Redatores.controller;

import com.Headot.Redatores.model.Post;
import com.Headot.Redatores.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PostsControler {
    private final PostsService postsService = new PostsService();

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @PostMapping("/getById")
    public ModelAndView getPosts(@RequestParam("id") String id) {
        List<Post> response = postsService.getPostsById(id);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("posts", response);
        return mv;
    }

    @GetMapping("/all")
    public ModelAndView getAllPosts() {
        List<Post> posts = postsService.getAllPosts();
        ModelAndView mv = new ModelAndView("posts");
        mv.addObject("posts", posts);
        return mv;
    }

}
