package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService convertService;

    @GetMapping(value = "")
    public String inputConvert() {
        return "input";
    }

    @PostMapping(value = "/convert")
    public String convert(@RequestParam String rate, @RequestParam String usd, Model model) {
        double r = Double.parseDouble(rate);
        double u = Double.parseDouble(usd);
        double result=convertService.convert(r,u);
        model.addAttribute("convert", result);
        return "result";
    }
}
