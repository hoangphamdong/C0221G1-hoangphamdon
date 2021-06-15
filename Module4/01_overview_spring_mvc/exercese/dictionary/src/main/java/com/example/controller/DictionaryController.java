package com.example.controller;

import com.example.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    ITranslateService translateService;
    @GetMapping(value = "")
    public String inputDictionary(){
        return "input";
    }
    @PostMapping(value ="/translate")
    public String translateDictionary(@RequestParam String txtSearch, Model model){
        String result=translateService.translate(txtSearch);
        model.addAttribute("search",txtSearch);
        model.addAttribute("result",result);
        return "result";
    }
}
