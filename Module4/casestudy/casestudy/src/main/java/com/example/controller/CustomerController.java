package com.example.controller;

import com.example.Dto.CustomerDto;
import com.example.model.entity.Customer;
import com.example.model.entity.CustomerType;
import com.example.model.service.ICustomerService;
import com.example.model.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes() {
        return this.customerTypeService.findAll();
    }

    @GetMapping(value ={ "/list",""})
    public ModelAndView showListCustomer(@PageableDefault(size = 2) Pageable pageable,
                                         @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        Page<Customer> customers = customerService.pageAndSearch(pageable, keywordValue);
        ModelAndView modelAndView = new ModelAndView("customers/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("keywordValue", keywordValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("customers/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }
//    @PostMapping(value = "/save")
//    public String saveCustomer(@ModelAttribute CustomerDto customerDto,Model model,RedirectAttributes redirectAttributes){
//        Customer customer=new Customer();
//        BeanUtils.copyProperties(customerDto,customer);
//        this.customerService.save(customer);
//        return "redirect:customers/list";
//    }


    //        @PostMapping(value = "/save")
//    public String saveCustomer(@ModelAttribute Customer customer,
//                               RedirectAttributes redirectAttributes) {
//        this.customerService.save(customer);
//        redirectAttributes.addFlashAttribute("message", "create success");
//        return "redirect:/customers/list";
//    }
    @PostMapping(value = "/save")
    public String saveCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                               BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "customers/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "create new succcessfully");
        return "redirect:/customers/list";
    }
//    @PostMapping("/save")
//    public String createCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("customerTypes", customerTypeService.findAll());
//            return "customers/create";
//        } else {
//            String code = customerDto.getCode();
//            boolean check = true;
//            for (Customer cus : customerService.findAll()) {
//                if (id.equals(cus.getId())) {
//                    check = false;
//                    break;
//                }
//            }
//            if (check) {
//                customerService.save(customer);
//                redirectAttributes.addFlashAttribute("message", "create success!!!");
//                return "redirect:/customer/list";
//            } else {
//                model.addAttribute("messageId", "id đã tồn tại!!");
//                model.addAttribute("customerTypeList", customerTypeService.findAll());
//                return "customer/create";
//            }
//        }
//
//    }


    @GetMapping("/delete")
    public String deleteCustomerGet(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!");
        return "redirect:/customers/list";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("customers/edit");
            modelAndView.addObject("customer", customer.orElse(null));
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "edit succsess");
        return "redirect:/customers/list";
    }

    @GetMapping(value = "/view/{id}")
    public ModelAndView detail(@PathVariable int id) {
        Optional<Customer> customer = this.customerService.findById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("customers/view");
            modelAndView.addObject("customer", customer.orElse(null));
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }


}
