package com.example.controller;

import com.example.model.entity.Customer;
import com.example.model.entity.Province;
import com.example.model.service.ICustomerService;
import com.example.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.finAll();
    }

    @GetMapping(value = "/list")
    public ModelAndView listCustomers() {
        Iterable<Customer> customers = customerService.finAll();
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public ModelAndView save(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New Customer create successfully");
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer update successfully");
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!");
        return "redirect:/customer/list";
    }



}
