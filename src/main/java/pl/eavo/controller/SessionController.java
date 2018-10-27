package pl.eavo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.eavo.config.CustomSecurityUser;
import pl.eavo.model.entities.User;
import pl.eavo.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @Autowired
    private HttpSession session;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String setupSession(@AuthenticationPrincipal CustomSecurityUser customSecurityUser, Model model) {
        User user = userRepository.findByUsername(customSecurityUser.getUsername());

        session.setAttribute("user", user);

        return "redirect:/dashboard";
    }

}
