/**
 * Autor: Matheus Pires Gouveia dos Santos
 * Data do Término: 02/07/2021
 */

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

    /**
     * Método responsável por buscar no endpoint todas as postagens e separar somente as postagens de um redator específico, utilizando seu identificador único.
     * @param id Identificador único de um Redator.
     * @return Retorna uma lista de artigos redigidos por um redator específico.
     */
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

    /**
     * Método responsável por buscar no endpoint todas as postagens de todos redatores.
     * @return Retorna uma lista de artigos redigidos por todos os redatores.
     */
    public List<Post> getAllPosts() {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return new Gson().fromJson(response.getBody(), new TypeToken<List<Post>>() {
        }.getType());
    }
}
