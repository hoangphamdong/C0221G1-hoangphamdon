package com.example.controller;


import com.example.dto.PhoneNumberDto;
import com.example.model.enitty.PhoneNumber;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class phoneController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumberDto());
        return "/index";
    }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")PhoneNumberDto phoneNumberDto, BindingResult bindingResult, Model model){
        new PhoneNumberDto().validate(phoneNumberDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            PhoneNumber phoneNumber=new PhoneNumber();
            BeanUtils.copyProperties(phoneNumberDto,phoneNumber);
            model.addAttribute("phoneNumber", phoneNumber);
            return "/result";
        }
    }
}
