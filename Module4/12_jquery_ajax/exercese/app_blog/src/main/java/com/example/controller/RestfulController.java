package com.example.controller;

import com.example.model.entity.Blog;
import com.example.model.service.BlogService;
import com.example.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
public class RestfulController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping({"", "/list"})
    public ResponseEntity<Page<Blog>> listBogs(@RequestParam int page  ) {
        Page<Blog>page1=blogService.findAll(PageRequest.of(page,2));
        return new ResponseEntity<>(blogService.findAll(PageRequest.of(page,2)), HttpStatus.OK) ;
    }
}
