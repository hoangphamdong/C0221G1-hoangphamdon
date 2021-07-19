package com.example.controller;


import com.example.model.entity.Question;
import com.example.model.entity.QuestionType;

import com.example.model.service.IQuestionService;
import com.example.model.service.IQuestionTypeService;
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
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;
    @Autowired
   private IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypes")
    public Iterable<QuestionType> customerTypes() {
        return this.questionTypeService.findAll();
    }

    @GetMapping(value = {"/list", ""})
    public ModelAndView showListCustomer(@PageableDefault(size = 2) Pageable pageable,
                                         @RequestParam(name = "type") Optional<String> type,
                                         @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        String typeValue = "";

        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        if (type.isPresent()) {
            typeValue = type.get();
        }
        ModelAndView modelAndView = new ModelAndView("questions/list");
        Page<Question>questions=questionService.getQuestionByTitleAndType(keywordValue,typeValue,pageable);
        modelAndView.addObject("questions", questions);
        modelAndView.addObject("keywordValue", keywordValue);
        return modelAndView;
    }
    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("questions/create");
        modelAndView.addObject("question", new Question());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String saveCustomer( @ModelAttribute("question") Question question, RedirectAttributes redirectAttributes) {
        this.questionService.save(question);
        redirectAttributes.addFlashAttribute("message", "create new succcessfully");
        return "redirect:/question/list";
    }


    @GetMapping("/delete")
    public String deleteCustomerGet(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        questionService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete success!!!");
        return "redirect:/question/list";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Question> question = questionService.findById(id);
        ModelAndView modelAndView;
        if (question.isPresent()) {
            modelAndView = new ModelAndView("questions/edit");
            modelAndView.addObject("question", question.orElse(null));
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String save(@ModelAttribute(name = "question") Question question, RedirectAttributes redirectAttributes) {
        this.questionService.save(question);
        redirectAttributes.addFlashAttribute("message", "edit succsess");
        return "redirect:/question/list";
    }

    @GetMapping(value = "/view/{id}")
    public ModelAndView detail(@PathVariable int id) {
        Optional<Question> question = this.questionService.findById(id);
        ModelAndView modelAndView;
        if (question.isPresent()) {
            modelAndView = new ModelAndView("questions/view");
            modelAndView.addObject("question", question.orElse(null));
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

}
