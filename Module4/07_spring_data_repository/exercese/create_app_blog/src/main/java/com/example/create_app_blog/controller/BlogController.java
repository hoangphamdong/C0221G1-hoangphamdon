package com.example.create_app_blog.controller;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ModelAndView index() {
        return new ModelAndView("blog/index", "blogs", blogService.findAll());
    }

    @GetMapping("/blog/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/blog/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create", "blog", blog);
        modelAndView.addObject("message", "new blog created");
        return modelAndView;
    }

    @GetMapping("/blog/view/{id}")
    public ModelAndView viewDetail(@PathVariable Long id) {
        return new ModelAndView("blog/view", "blog", blogService.findById(id).orElse(null));
    }

    @GetMapping("/blog/edit/{id}")
    public ModelAndView viewEditBlog(@PathVariable Long id) {
        return new ModelAndView("blog/update", "blog", blogService.findById(id));
    }

    @PostMapping("/blog/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/update", "blog", blog);
        modelAndView.addObject("message", "Updated successfully!");
        return modelAndView;
    }

    @GetMapping("/blog/delete/{id}")
    public ModelAndView viewDelete(@PathVariable Long id) {
        return new ModelAndView("blog/delete", "blog", blogService.findById(id));
    }

    @PostMapping("/blog/delete")
    public ModelAndView delete(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        ModelAndView modelAndView = new ModelAndView("blog/index", "message", "Deleted Successfuly");
        return modelAndView;
    }
}
