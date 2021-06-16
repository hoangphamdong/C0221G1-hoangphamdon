package com.example.controler;

import com.example.service.IValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @Autowired
    IValidateService validateService;
    @GetMapping(value = "")
    public String loadIndex(){
        return "/index";
    }
    @PostMapping(value = "/validate")
    public String validateEmail(@RequestParam (name = "email") String email, Model model){
        boolean isValid=this.validateService.validate(email);
        if(!isValid){
            model.addAttribute("message","Email is valid");
            model.addAttribute("email",email);
            return "/index";
        }
        model.addAttribute("email",email);
        return "/success";
    }
}
