package pl.eavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.eavo.model.entities.Refuel;
import pl.eavo.model.entities.User;
import pl.eavo.model.entities.Vehicle;
import pl.eavo.repository.RefuelRepository;
import pl.eavo.repository.VehicleRepository;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class RefuelController {

    User user;
    Vehicle vehicle;

    @Autowired
    RefuelRepository refuelRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    HttpSession session;

    @RequestMapping(value = "/refuel", method = RequestMethod.GET)
    public String getRefuelMain(Model model) {
        User user = (User) session.getAttribute("user");
        Vehicle vehicle = vehicleRepository.findVehiclesByUser(user).get(0);
        List<Refuel> refuelList = refuelRepository.findAllRefuelsByVehicle(vehicle);

        Refuel previousRefuel = refuelList.isEmpty() ? new Refuel() : refuelList.get(0);

        refuelList.remove(0);
        Collections.reverse(refuelList);

        model.addAttribute("user", user);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("refuelList", refuelList);
        model.addAttribute("previousRefuel", previousRefuel);

        return "refuel";
    }

    @RequestMapping(value = "/refuel/add", method = RequestMethod.POST)
    public String postRefuelForVehicle(Model model, @ModelAttribute(name = "refuel") Refuel refuel) {
        User user = (User) session.getAttribute("user");
        Vehicle vehicle = vehicleRepository.findVehiclesByUser(user).get(0);
        List<Refuel> refuelList = refuelRepository.findAllRefuelsByVehicle(vehicle);
        Collections.reverse(refuelList);
        Refuel previousRefuel = refuelList.isEmpty() ? new Refuel() : refuelList.get(refuelList.size() - 1);

        refuel.setVehicle(vehicle);

        refuelRepository.save(refuel);

        model.addAttribute("user", user);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("refuelList", refuelList);
        model.addAttribute("previousRefuel", previousRefuel);

        return "redirect:/refuel";
    }
}
