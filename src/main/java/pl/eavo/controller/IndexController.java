package pl.eavo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"", "/", "/index", "home"})
    public String homeView(Model model){
        model.addAttribute("header", "Home Page");
        return "home";
    }
}
