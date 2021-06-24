package com.example.controller;

import com.example.model.entity.Product;
import com.example.model.entity.TypeProduct;
import com.example.model.service.IProductService;
import com.example.model.service.ITypeProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.Optional;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ITypeProductService typeProductService;

    @ModelAttribute("typeProducts")
    public Iterable<TypeProduct> typeProducts() {
        return this.typeProductService.findByAll();
    }

    @GetMapping("/list")
    public ModelAndView showListProduct(@PageableDefault(size = 2) Pageable pageable,
                                        @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        Page<Product> products = productService.getProductBySearchingName(pageable, keywordValue);
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", products);
        modelAndView.addObject("keywordValue", keywordValue);
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
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("products/create");
        Iterable<TypeProduct> typeProducts = this.typeProductService.findByAll();
        modelAndView.addObject("typeProducts", typeProducts);
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public ModelAndView save(@ModelAttribute(name = "product") Product product) {
        this.productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/products/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "create sucsess");
        return modelAndView;
    }

    @GetMapping(value = "/view/{id}")
    public ModelAndView showView(@PathVariable(name = "id") Long id) {
        Optional<Product> product = this.productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/products/view");
        modelAndView.addObject("product", product.get());
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable(name = "id") Long id) {
        Optional<Product> product = this.productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("products/delete");
        modelAndView.addObject("product", product.get());
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(name = "product") Product product, RedirectAttributes redirectAttributes) {
        this.productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "delete sucess");
        return "redirect:/product/list";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable(name = "id") Long id) {
        Optional<Product> product = this.productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("products/edit");
        modelAndView.addObject("product", product.get());
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute(name = "product") Product product, RedirectAttributes redirectAttributes) {
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("message", "update sucess");
        return "redirect:/product/list";
    }

}
