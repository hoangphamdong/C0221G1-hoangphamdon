package com.example.controller;

import com.example.Dto.EmployeeDto;
import com.example.model.entity.*;
import com.example.model.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IUserService userService;
    @Autowired
    IEmployeeService employeeService;

    @ModelAttribute("positions")
    public Iterable<Position> positions() {
        return this.positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees() {
        return this.educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public Iterable<Division> divisions() {
        return this.divisionService.findAll();
    }

    @ModelAttribute("users")
    public Iterable<AppUser> users() {
        return this.userService.findAll();
    }

    @GetMapping(value = {"", "/list"})
    public ModelAndView showListEmployee(@PageableDefault(size = 2) Pageable pageable,
                                         @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        Page<Employee> employees = this.employeeService.pageAndSearch(pageable, keywordValue);
        ModelAndView modelAndView = new ModelAndView("employees/list");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("keywordValue", keywordValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("employees/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute(name = "employeeDto") EmployeeDto employeeDto,
                               BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "employees/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "create employee success");
        return "redirect:/employees/list";
    }

    @GetMapping(value = "view/{id}")
    public ModelAndView viewEmployee(@PathVariable(name = "id") int id) {
        Optional<Employee> employee = this.employeeService.findById(id);
        ModelAndView modelAndView;
        if (employee.isPresent()) {
            modelAndView = new ModelAndView("employees/view");
            modelAndView.addObject("employee", employee.orElse(null));
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }
    @GetMapping(value = "/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") int id){
        Optional<Employee>employee=this.employeeService.findById(id);
        ModelAndView modelAndView;
        if(employee.isPresent()){
            EmployeeDto employeeDto=new EmployeeDto();
            BeanUtils.copyProperties(employee.get(),employeeDto);
            modelAndView=new ModelAndView("employees/edit");
            modelAndView.addObject("employeeDto",employeeDto);
        }
        else {
            modelAndView=new ModelAndView("/error.404");
        }
        return modelAndView;
    }
    @PostMapping(value = "/edit")
    public String editEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                               BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("employeeDto",employeeDto);
            return "/employees/edit";
        }
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            this.employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message","edit success");
        return "redirect:/employees/list";
    }
    @PostMapping(value = "/delete")
    public String deleteEmployee(@RequestParam ("id")int id,RedirectAttributes redirectAttributes){
        this.employeeService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:/employees/list";
    }

}
