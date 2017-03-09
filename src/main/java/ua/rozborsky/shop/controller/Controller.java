package ua.rozborsky.shop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.rozborsky.shop.classes.DAOImpl;
import ua.rozborsky.shop.classes.RegisteredPerson;

/**
 * Created by roman on 25.02.2017.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        new DAOImpl();

        return "home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        new DAOImpl();//-----------------------

        model.addAttribute("registeredPerson", new RegisteredPerson());


        return "registration";
    }

@RequestMapping(value = "/processingRegistration", method = RequestMethod.POST)
    public String processingRegistration(@ModelAttribute("registeredPerson") RegisteredPerson registeredPerson) {

    System.out.println(registeredPerson.getName());
    System.out.println(registeredPerson.getSurname());
    System.out.println(registeredPerson.getAddress());
    System.out.println(registeredPerson.getPhone());
    System.out.println(registeredPerson.getPassword());
    System.out.println(registeredPerson.getConfirmPassword());

        return "cabinet";
    }

}
