package com.example.controller;

import com.example.model.entity.Comment;
import com.example.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    private ICommentService commentService;
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comment", new Comment());
        List<Comment> comments = commentService.findAll();
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }
}
