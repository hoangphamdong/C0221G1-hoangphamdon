package com.example.controller;

import com.example.model.entity.Contract;
import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import com.example.model.entity.Service;
import com.example.model.repository.ICustomerRepository;
import com.example.model.service.IContractService;
import com.example.model.service.ICustomerService;
import com.example.model.service.IEmployeeService;
import com.example.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/contracts")
public class ContractController {
//    @Autowired
//    IEmployeeService employeeService;
//    @Autowired
//    ICustomerService customerService;
//    @Autowired
//    IServiceService serviceService;
//    @Autowired
//    IContractService contractService;
//
//    @ModelAttribute("employees")
//    public Iterable<Employee> employees() {
//        return this.employeeService.findAll();
//    }
//
//    @ModelAttribute("customers")
//    public Iterable<Customer> customers() {
//        return this.customerService.findAll();
//    }
//
//    @ModelAttribute("services")
//    public Iterable<Service> services() {
//        return this.serviceService.findAll();
//    }
//
//    @GetMapping("/create")
//    public ModelAndView showFormCreateContract() {
//        ModelAndView modelAndView = new ModelAndView("contracts/create");
//        modelAndView.addObject("contract", new Contract());
//        return modelAndView;
//    }
//
//    @PostMapping(value = "/save")
//    public String saveContract(@ModelAttribute(name = "contract") Contract contract,
//                               Model model, RedirectAttributes redirectAttributes) {
//        this.contractService.save(contract);
//        redirectAttributes.addFlashAttribute("message","create success");
//        return "redirect:/contracts/create";
//
//    }
//    @GetMapping(value = "/list")
//    public ModelAndView showListContract(@PageableDefault(size = 2)Pageable pageable,
//                                         @RequestParam Optional<String> keyword){
//        String keywordValue ="";
//        if (keyword.isPresent()){
//            keywordValue=keyword.get();
//        }
//        Page<Contract>contracts=contractService.pageAndSearch(pageable,keywordValue);
//        ModelAndView modelAndView=new ModelAndView("contracts/list");
//        modelAndView.addObject("contracts",contracts);
//        modelAndView.addObject("keywordValue",keywordValue);
//        return modelAndView;
//    }
}
