package pl.eavo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pl.eavo.model.entities.User;

@Controller
public class RefuelController {



    public String getRefuelMain(@AuthenticationPrincipal User user, Model model){

        return "refuel";
    }

}
