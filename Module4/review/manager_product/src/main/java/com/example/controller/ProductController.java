package com.example.controller;

import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping(value = "/show-list-product")
    public String showListProduct(Model model){
        model.addAttribute("products",productService.findAll());
        return "product/index";
    }
}
