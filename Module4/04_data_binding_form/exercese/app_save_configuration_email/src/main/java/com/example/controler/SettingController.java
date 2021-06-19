package com.example.controler;

import com.example.model.bean.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/setting")
public class SettingController {
    @GetMapping(value = "/showForm")
    public String showFormSetting(Model model){
        model.addAttribute("showSetting",new Setting());
        model.addAttribute("languages" ,new String[]{"English","Vietnamese","Japanese","Chinese"});
        model.addAttribute("size",new String[]{"5","10","15","25","50","100"});
        return "/setting/showForm";
    }
    @PostMapping(value = "create-setting")
    public ModelAndView creatSetting(@ModelAttribute("showSetting") Setting setting){
        ModelAndView modelAndView=new ModelAndView("/setting/createSetting","createSetting",setting);
        return modelAndView;
    }

}
