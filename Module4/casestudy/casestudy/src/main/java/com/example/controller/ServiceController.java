package com.example.controller;

import com.example.Dto.ServiceDto;
import com.example.model.entity.RenType;
import com.example.model.entity.Service;
import com.example.model.entity.ServiceType;
import com.example.model.service.IRenTypeService;
import com.example.model.service.IServiceService;
import com.example.model.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/services")
public class ServiceController {
    @Autowired
    IServiceService service;
    @Autowired
    IRenTypeService renTypeService;
    @Autowired
    IServiceTypeService serviceTypeService;

    @ModelAttribute("renTypes")
    public Iterable<RenType> renTypes() {
        return this.renTypeService.findAll();
    }

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return this.serviceTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateService() {
        ModelAndView modelAndView = new ModelAndView("services/create");
        modelAndView.addObject("serviceDto", new ServiceDto());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String saveService(@Valid @ModelAttribute(name = "serviceDto") ServiceDto serviceDto,
                              BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceDto", serviceDto);
            return "services/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        this.service.save(service);
        redirectAttributes.addFlashAttribute("massage", "create success");
        return "redirect:/services/create";
    }

}
