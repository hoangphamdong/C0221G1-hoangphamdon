package com.example.create_app_blog.controller;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog")
    public ModelAndView index() {
        return new ModelAndView("index", "blogs", blogService.findAll());
    }

    @GetMapping("/blog/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/blog/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("create", "blog", blog);
        modelAndView.addObject("message", "new blog created");
        return modelAndView;
    }

    @GetMapping("/blog/view/{id}")
    public ModelAndView viewDetail(@PathVariable int id) {
        return new ModelAndView("view", "blog",blogService.findById(id).orElse(null) );
    }

    @GetMapping("/blog/edit/{id}")
    public ModelAndView viewEditBlog(@PathVariable int id) {
        return new ModelAndView("update", "blog", blogService.findById(id));
    }

    @PostMapping("/blog/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("update", "blog", blog);
        modelAndView.addObject("message", "Updated successfully!");
        return modelAndView;
    }

    @GetMapping("/blog/delete/{id}")
    public ModelAndView viewDelete(@PathVariable int id) {
        return new ModelAndView("delete", "blog", blogService.findById(id));
    }

    @PostMapping("/blog/delete")
    public ModelAndView delete(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        ModelAndView modelAndView = new ModelAndView("index", "message", "Deleted Successfuly");
        return modelAndView;
    }
}
