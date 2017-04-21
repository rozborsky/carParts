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
import ua.rozborsky.shop.interfaces.Encoder;
import ua.rozborsky.shop.interfaces.Mail;

import javax.validation.Valid;


/**
 * Created by roman on 25.02.2017.
 */
@org.springframework.stereotype.Controller
public class RegistrationController {
    @Autowired
    private DAO dao;

    @Autowired
    @Qualifier("tmpPerson")
    private User tmpUser;

    @Autowired
    private Mail mail;

    @Autowired
    private TimeManager timeManager;

    @Autowired
    private Encoder encoder;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("tmpUser", tmpUser);

        return "registration";
    }

    @RequestMapping(value = "/processingRegistration", method = RequestMethod.POST)
    public String confirmRegistration(@Valid @ModelAttribute(value = "tmpUser")
                                              TmpUser tmpUser, BindingResult bindingResult) {
        if(!tmpUser.getPassword().equals(tmpUser.getConfirmPassword())) {
            bindingResult.rejectValue("password", "isValid", "паролі не співпадають");//todo exseption binding result - empty fields
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        String password = encoder.code(tmpUser.getPassword());
        tmpUser.setPassword(password);
        long timestamp = timeManager.getCurrentTimestamp();
        tmpUser.setTimestamp(timestamp);
        dao.saveUser(tmpUser);

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
            return "redirect:/codeNotValid";
        }
    }

    @RequestMapping(value = "/finishRegistration", method = RequestMethod.GET)
    public String finishRegistration() {
        return "finishRegistration";
    }

    @RequestMapping(value = "/codeNotValid", method = RequestMethod.GET)
    public String codeNotValid() {
        return "codeNotValid";
    }

}
