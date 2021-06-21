package com.example.controller;

import com.example.entity.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping(value = {"","/list"})
    public String showProductList(Model model){
        model.addAttribute("listProduct",this.productService.findAll());
        return "products/product-list";
    }
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "products/product-form-create";
    }
    @PostMapping(value = "/save")
    public String save(Model model, @ModelAttribute Product product,
                       RedirectAttributes redirectAttributes){
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("massage","Register success");
        return "redirect:/product/list";

    }


}
