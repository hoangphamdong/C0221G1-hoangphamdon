package com.example.controller;

import com.example.model.entity.Product;
import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public ModelAndView showListProduct(@PageableDefault(size =2 )Pageable pageable,
                                        @RequestParam Optional<String> keyword) {
        String keywordValue="";
        if (keyword.isPresent()){
            keywordValue=keyword.get();
        }
        Page<Product> products = productService.getProductBySearchingName(pageable,keywordValue);
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", products);
        modelAndView.addObject("keywordValue",keywordValue);
        return modelAndView;
    }
//    @GetMapping("/list")
//    public ModelAndView showListProduct() {
//        Iterable<Product> products = productService.findByAll();
//        ModelAndView modelAndView = new ModelAndView("products/list");
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }
    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView=new ModelAndView("products/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping(value = "/create")
    public ModelAndView save(@ModelAttribute(name = "product") Product product){
        this.productService.save(product);
       ModelAndView modelAndView=new ModelAndView("/products/create");
       modelAndView.addObject("product",new Product());
       modelAndView.addObject("message","create sucsess");
       return modelAndView;
    }
    @GetMapping(value = "/view/{id}")
    public ModelAndView showView(@PathVariable (name = "id")Long id){
        Optional<Product>product=this.productService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/products/view");
        modelAndView.addObject("product",product.get());
        return modelAndView;
    }

}
