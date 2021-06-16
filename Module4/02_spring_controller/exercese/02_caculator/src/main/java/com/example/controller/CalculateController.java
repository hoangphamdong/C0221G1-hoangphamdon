package com.example.controller;

import com.example.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
   @Autowired
   ICalculateService calculateService;
   @GetMapping(value = "")
   public String loadIndex(){
      return "/index";
   }
   @PostMapping(value = "/calculator")
   public String calculate (Model model,
                            @RequestParam (name="number1", defaultValue = "0") double number1,
                            @RequestParam (name = "number2",defaultValue = "0") double number2,
                            @RequestParam(name ="calculator",defaultValue = "") String calculate)
   {
      double result=calculateService.calculator(number1,number2,calculate);
      model.addAttribute("number1",number1);
      model.addAttribute("number2",number2);
      model.addAttribute("result",result);
      return "/index";
   }
}
