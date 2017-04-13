package ua.rozborsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.rozborsky.shop.classes.TimeManager;
import ua.rozborsky.shop.dbClasses.TmpUser;
import ua.rozborsky.shop.dbClasses.User;
import ua.rozborsky.shop.interfaces.DAO;
import ua.rozborsky.shop.interfaces.Mail;

import javax.validation.Valid;

/**
 * Created by roman on 25.02.2017.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private DAO dao;

    @Autowired
    @Qualifier("tmpPerson")
    private User tmpUser;

    @Autowired
    Mail mail;

    @Autowired
    TimeManager timeManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("tmpUser", tmpUser);


        return "registration";
    }

    @RequestMapping(value = "/processingRegistration", method = RequestMethod.POST)
    public String confirmRegistration(@Valid @ModelAttribute(value = "registeredPerson")
                                              TmpUser tmpUser, BindingResult bindingResult) {
        if(!tmpUser.getPassword().equals(tmpUser.getConfirmPassword())) {
            bindingResult.rejectValue("password", "isValid", "паролі не співпадають");//todo exseption binding result - empty fields
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        long timestamp = timeManager.getCurrentTimestamp();
        tmpUser.setTimestamp(timestamp);
        dao.saveUser(tmpUser);

//        timestamp = 1234;//todo tmp
        mail.send(tmpUser.geteMail(), "http://localhost/shop/finishRegistration/" + timestamp);

        return "confirmRegistration";
    }


    @RequestMapping(value = "/finishRegistration/{timestamp}", method = RequestMethod.GET)
    public String checkUrl(@PathVariable(value="timestamp") long timestamp) {
        TmpUser user = dao.getUser(timestamp);
        if (user != null){
            dao.registerUser(user);

            return "redirect:/finishRegistration";
        } else {
            return "redirect:/error404";
        }
    }

    @RequestMapping(value = "/finishRegistration", method = RequestMethod.GET)
    public String finishRegistration() {
        return "finishRegistration";
    }

    @RequestMapping(value = "/error404", method = RequestMethod.GET)
    public String error404() {
        return "error404";
    }

}
