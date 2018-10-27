package pl.eavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import pl.eavo.model.entities.User;
import pl.eavo.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    private UserService userService;
    private HttpSession session;

    @Autowired
    public AccountController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String accountView(Model model) {

        return "account";
    }
}
