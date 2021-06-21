package com.example.controller;

import com.example.model.entity.Customer;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping(value = "/show-list")
    public String showListCustomer(Model model){
        model.addAttribute("listCustomer",this.customerService.findAll());
        return "customer/list";
    }
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping(value = "/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/customer/show-list";
    }
    @GetMapping(value = "/delete")
    public String showFormDelete(@RequestParam int id, Model model){
        model.addAttribute("customer",this.customerService.findById(id));
        return "customer/delete";
    }
    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(name = "customer") Customer customer,RedirectAttributes redirectAttributes){
        this.customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message","Delete success");
        return "redirect:/customer/show-list";
    }
}
