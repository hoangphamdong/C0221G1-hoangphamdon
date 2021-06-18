package com.example.controller;

import com.example.model.bean.Product;
import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping(value = "")
    public String index(Model model){
        List<Product>productList=productService.findAll();
        model.addAttribute("products",productList);
        return "products/index";
    }
    @GetMapping(value = "/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "products/create";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        product.setProductId((int) (Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","create success..!");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@RequestParam int id,Model model){
        model.addAttribute("products",productService.findById(id));
        return "products/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.update(product.getProductId(),product);
        redirectAttributes.addFlashAttribute("success","update success");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@RequestParam int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "products/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product,RedirectAttributes redirectAttributes){
        productService.remove(product.getProductId());
        redirectAttributes.addFlashAttribute("success","Delete success");
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(@RequestParam int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "products/view";
    }
    @PostMapping("/search")
    public String search(@RequestParam String search,Model model){
        List<Product>productList=productService.search(search);
        model.addAttribute("products",productList);
        return "products/index";
    }


}