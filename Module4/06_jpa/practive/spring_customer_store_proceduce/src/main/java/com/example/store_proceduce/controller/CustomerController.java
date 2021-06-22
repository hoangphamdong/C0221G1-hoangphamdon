package com.example.store_proceduce.controller;

import com.example.store_proceduce.model.entity.Customer;
import com.example.store_proceduce.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping(value = "/list")
    public ModelAndView listCustomer(){
        List<Customer> customers=customerService.findAll();
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreateForm() {
        return "create";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute (name = "last") String last, @ModelAttribute(name = "first") String first){
        customerService.create(last,first);
        return "redirect:/customer/list";
    }
}
