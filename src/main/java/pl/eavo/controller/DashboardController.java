package pl.eavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.eavo.config.CustomSecurityUser;
import pl.eavo.model.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    private User user;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"", "/dashboard"}, method = RequestMethod.GET)
    public String dashboardView(Model model) {

        user = (User) session.getAttribute("user");

        System.out.println(user.getUsername());

        model.addAttribute("user", user);

        return "dashboard";
    }

}
