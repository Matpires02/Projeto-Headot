/**
 * Autor: Matheus Pires Gouveia dos Santos
 * Data do Término: 02/07/2021
 */
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

    /**
     * Metodo responsável por indicar a pagina inicial do sistema
     * @return Página html inicial pelo ModelAndView
     */
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * Método responsalvel por pegar os artigos de um determinado redator e envia-los para serem exibidos.
     * @param id Identificador único de um Redator.
     * @return Página html inicial pelo ModelAndView, agora contendo informações dos artigos escritos por ele.
     */
    @PostMapping("/getById")
    public ModelAndView getPosts(@RequestParam("id") String id) {
        List<Post> response = postsService.getPostsById(id);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("posts", response);
        return mv;
    }

    /**
     * Método responsalvel por pegar todos os artigos para serem exibidos.
     * @return  Retorna uma Página html com todos os artigos disponíveis.
     */
    @GetMapping("/all")
    public ModelAndView getAllPosts() {
        List<Post> posts = postsService.getAllPosts();
        ModelAndView mv = new ModelAndView("posts");
        mv.addObject("posts", posts);
        return mv;
    }

}
