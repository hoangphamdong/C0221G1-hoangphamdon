package com.example.create_app_blog.controller;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.entity.Category;
import com.example.create_app_blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<Category>> index() {
        List<Category>categories=(List<Category>) categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(categories, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);

    }
    @GetMapping("/view/{id}")
    public ResponseEntity<Category> viewDetail(@PathVariable Long id) {
        Optional<Category>category=categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.get(),HttpStatus.OK);
    }



}
