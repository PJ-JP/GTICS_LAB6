package com.pucp.demo.controller;

import com.pucp.demo.entity.BlogPost;
import com.pucp.demo.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<BlogPost> lista = blogPostRepository.findAll();
        model.addAttribute("lista", lista);
        return "/blog/home";
    }

    @GetMapping("/nuevo")
    public String newPost(Model model) {
        return "/blog/new";
    }

    @PostMapping("/guardar")
    public String savePost(BlogPost blogPost) {
        LocalDate localDate = LocalDate.now();
        blogPost.setFechaPublicacion(localDate.toString());
        blogPostRepository.save(blogPost);
        return "redirect:/";
    }

    @GetMapping("/borrar")
    public String delete(@RequestParam int id) {
        blogPostRepository.deleteById(id);
        return "redirect:/";
    }
}