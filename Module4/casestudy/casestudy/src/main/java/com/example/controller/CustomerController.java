package com.example.controller;

import com.example.model.entity.customer.Customer;
import com.example.model.entity.customer.CustomerType;
import com.example.model.repository.customers.ICustomerRepository;
import com.example.model.service.customers.ICustomerService;
import com.example.model.service.customers.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerType")
    public Iterable<CustomerType> customerTypes() {
        return this.customerTypeService.findAll();
    }

    @GetMapping (value = "/list")
    public ModelAndView showListCustomer(@PageableDefault(size=5)Pageable pageable,
                                         @RequestParam Optional<String> keyword){
        String keywordValue="";
        if(keyword.isPresent()){
            keywordValue=keyword.get();
        }
        Page<Customer>customers=customerService.pageAndSearch(pageable,keywordValue);
        ModelAndView modelAndView =new ModelAndView("customers/list");
        modelAndView.addObject("customers",customers);
        modelAndView.addObject("keywordValue",keywordValue);
        return modelAndView;
    }

}
