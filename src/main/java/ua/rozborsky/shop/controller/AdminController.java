package ua.rozborsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborsky.shop.classes.Category;
import ua.rozborsky.shop.interfaces.DaoGoods;

import java.util.List;

/**
 * Created by roman on 20.04.2017.
 */
@org.springframework.stereotype.Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    DaoGoods daoGoods;

    @Autowired
    Category category;

    @GetMapping(value = "/manageCategories")
    public ModelAndView manageCategories() {

        System.out.println("manageCategories");
        List<Category> categories = daoGoods.getCategories();
        ModelAndView modelAndView = new ModelAndView("manageCategories");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("category", category);

        return modelAndView;
    }

    @PostMapping (value = "/manageCategories")
    public ModelAndView addCategories(@ModelAttribute("category") Category category) {
        daoGoods.addCategory(category);

        List<Category> categories = daoGoods.getCategories();
        ModelAndView modelAndView = new ModelAndView("manageCategories");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("category", category);

        return modelAndView;
    }

    @GetMapping(value = "/deleteCategory/{name}")
    public String deleteCategory(@PathVariable(value="name") String name) {
        daoGoods.deleteCategory(name);

        return "redirect:/admin/manageCategories";
    }
}
