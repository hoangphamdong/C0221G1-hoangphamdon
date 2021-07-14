package com.example.controller;

import com.example.model.entity.AttachService;
import com.example.model.entity.Contract;
import com.example.model.entity.ContractDetail;
import com.example.model.service.IAttachServiceService;
import com.example.model.service.IContractDetailService;
import com.example.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/contractDetail")
public class ContractDetailController {
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachServiceService attachServiceService;
    @Autowired
    IContractDetailService contractDetailService;

    @ModelAttribute("contracts")
    public Iterable<Contract>contracts(){
        return this.contractService.findAll();
    }
    @ModelAttribute("attachServices")
    public Iterable<AttachService>attachServices(){
        return this.attachServiceService.findAll();
    }
    @GetMapping("/create")
    public ModelAndView showFormCreateContractDetail(){
        ModelAndView modelAndView=new ModelAndView("contractDetails/create");
        modelAndView.addObject("contractDetail",new ContractDetail());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute (name = "contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        this.contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message","create contract detail success");
        return "redirect:/contractDetails/create";
    }
}
