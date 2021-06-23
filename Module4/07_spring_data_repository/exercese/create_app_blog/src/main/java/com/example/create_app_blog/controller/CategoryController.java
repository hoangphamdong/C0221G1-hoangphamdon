package com.example.create_app_blog.controller;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.entity.Category;
import com.example.create_app_blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/list")
    public ModelAndView index() {
        return new ModelAndView("category/list", "category", categoryService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create", "category", category);
        modelAndView.addObject("message", "new category created");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable Long id) {
        return new ModelAndView("category/view", "category", categoryService.findById(id).orElse(null));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEditBlog(@PathVariable Long id) {
        return new ModelAndView("category/edit", "category", categoryService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/edit", "category", category);
        modelAndView.addObject("message", "Updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView viewDelete(@PathVariable Long id) {
        return new ModelAndView("category/delete", "category", categoryService.findById(id).get());
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("category") Category category) {
         categoryService.remove(category.getId());
        return "redirect:/category/list";
    }
}
