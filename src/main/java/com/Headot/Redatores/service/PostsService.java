package com.Headot.Redatores.service;

import com.Headot.Redatores.model.Post;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> getPostsById(String id) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        List<Post> posts = new Gson().fromJson(response.getBody(), new TypeToken<List<Post>>() {
        }.getType());
        List<Post> requirePosts = new ArrayList<>();
        assert posts != null;
        for (Post post : posts) {
            if (post.getUserId().equals(id)) {
                requirePosts.add(post);
            }
        }
        return requirePosts;
    }

    public List<Post> getAllPosts() {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return new Gson().fromJson(response.getBody(), new TypeToken<List<Post>>() {
        }.getType());
    }
}
