package com.example.validate.controller;

import com.example.validate.model.dto.UserDto;
import com.example.validate.model.entity.User;
import com.example.validate.model.servie.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping(value = "/")
    public ModelAndView showListUser(){
        Iterable<User>users=this.userService.finAll();
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("user",users);
        return modelAndView;
    }
    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("userDto",new UserDto());
        return modelAndView;
    }
    @PostMapping(value = "/create")
    public String create(@Valid @ModelAttribute(name = "userDto")  UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("listUser",this.userService.finAll());
            return "/create";
        }
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        this.userService.save(user);
        redirectAttributes.addFlashAttribute("msg","create new successfully");
        return "redirect:/";

    }
}
