package ua.rozborsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(value = "/categories")
    public ModelAndView categories() {
        addCategory();//todo tmp

        List<Category> categories = daoGoods.getCategories();
        ModelAndView modelAndView = new ModelAndView("categories");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("category", category);

        return modelAndView;
    }

    @PostMapping (value = "/categories")
    public ModelAndView addCategories(@ModelAttribute("newCategoru") Category category) {
        daoGoods.addCategory(category);

        List<Category> categories = daoGoods.getCategories();
        ModelAndView modelAndView = new ModelAndView("categories");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("category", category);

        return modelAndView;
    }


    private void addCategory(){//todo tmp
        Category category1 = new Category();
        category1.setName("C1");
        daoGoods.addCategory(category1);
        Category category2 = new Category();
        category2.setName("C2");
        daoGoods.addCategory(category2);
        Category category3 = new Category();
        category3.setName("C3");
        daoGoods.addCategory(category3);
    }



}
