package ua.rozborsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.rozborsky.shop.dbClasses.RegisteredPerson;
import ua.rozborsky.shop.interfaces.DAO;
import ua.rozborsky.shop.interfaces.Mail;
import ua.rozborsky.shop.interfaces.Person;

import javax.validation.Valid;

/**
 * Created by roman on 25.02.2017.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private DAO dao;

    @Autowired
    private Person person;

    @Autowired
    Mail mail;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("registeredPerson", person);


        return "registration";
    }

    @RequestMapping(value = "/processingRegistration", method = RequestMethod.POST)
    public String confirmRegistration(@Valid @ModelAttribute(value = "registeredPerson")
                                                  RegisteredPerson person, BindingResult bindingResult) {
        if(!person.getPassword().equals(person.getConfirmPassword())) {
            bindingResult.rejectValue("password", "isValid", "паролі не співпадають");
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        dao.savePerson(person);
        mail.send(person.geteMail(), "www.carParts.ua");

        return "confirmRegistration";
    }

}
