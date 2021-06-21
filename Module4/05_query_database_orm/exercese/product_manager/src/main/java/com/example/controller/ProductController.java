package com.example.controller;

import com.example.model.entity.Product;
import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping(value = "/show-productList")
    public String showListProduct(Model model){
        model.addAttribute("productList",this.productService.findAll());
        return "products/list";
    }
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "products/create";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute(name = "product") Product product,RedirectAttributes redirectAttributes){
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/product/show-productList";
    }
    @GetMapping(value = "/delete")
    public String showFormDelete(@RequestParam int id, Model model){
        model.addAttribute("product",this.productService.findById(id));
        return "products/form-delete";
    }
    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(name = "product")Product product, RedirectAttributes redirectAttributes){
        this.productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:/product/show-productList";
    }
    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("viewProduct",this.productService.findById(id));
        return "/products/view";
    }
    @GetMapping(value = "/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("product",this.productService.findById(id));
        return "/products/edit";
    }
    @PostMapping(value = "/update")
    public String update(@ModelAttribute(name = "product") Product product,RedirectAttributes redirectAttributes){
        this.productService.update(product);
        redirectAttributes.addFlashAttribute("message","update success");
        return "redirect:/product/show-productList";
    }
}
