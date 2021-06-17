package com.example.controller;

import com.example.model.bean.Login;
import com.example.model.bean.User;
import com.example.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/user/home", "login", new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = userService.checkLogin(login);
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("/user/error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/user/user", "user", user);
            return modelAndView;
        }
    }
}
