package ua.rozborsky.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by roman on 25.02.2017.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "redirect:/home";
    }
}
