package com.example.create_app_blog.controller;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.entity.Category;
import com.example.create_app_blog.model.service.IBlogService;
import com.example.create_app_blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> provinces() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Blog>> listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        List<Blog> blogs=(List<Blog>) blogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(blogs, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }


    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> viewDetail(@PathVariable Long id) {
        Optional<Blog>blog=blogService.findById(id);
        if(!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }


}
