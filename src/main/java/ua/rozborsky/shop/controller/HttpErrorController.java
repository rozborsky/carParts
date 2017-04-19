package ua.rozborsky.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by roman on 19.04.2017.
 */
@org.springframework.stereotype.Controller
public class HttpErrorController {

    @RequestMapping(value="/404")
    public String error404(){

        return "pageNotFound";
    }
}
