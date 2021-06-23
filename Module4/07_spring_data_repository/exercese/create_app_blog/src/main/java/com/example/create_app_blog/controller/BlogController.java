package com.example.create_app_blog.controller;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.entity.Category;
import com.example.create_app_blog.model.service.IBlogService;
import com.example.create_app_blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> provinces() {
        return categoryService.findAll();
    }

//    @GetMapping("/list")
//    public ModelAndView index() {
//        return new ModelAndView("blog/index", "blogs", blogService.findAll());
//    }
//    @GetMapping("/list")
//    public ModelAndView index(@RequestParam("search") Optional<String> search,Pageable pageable) {
//        Page<Blog> blogs;
//        if(search.isPresent()){
//            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
//        } else {
//            blogs = blogService.findAll(pageable);
//        }
//        return new ModelAndView("blog/index", "blogs", blogService.findAll(pageable));
//    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Blog> blogs;
        if(search.isPresent()){
            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create", "blog", blog);
        modelAndView.addObject("message", "new blog created");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable Long id) {
        return new ModelAndView("blog/view", "blog", blogService.findById(id).orElse(null));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEditBlog(@PathVariable Long id) {
        return new ModelAndView("blog/update", "blog", blogService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/update", "blog", blog);
        modelAndView.addObject("message", "Updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView viewDelete(@PathVariable Long id) {
        return new ModelAndView("blog/delete", "blog", blogService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        ModelAndView modelAndView = new ModelAndView("blog/index", "message", "Deleted Successfuly");
        return modelAndView;
    }
}
