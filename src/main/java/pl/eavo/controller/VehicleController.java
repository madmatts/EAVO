package pl.eavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.eavo.model.entities.User;
import pl.eavo.model.entities.Vehicle;
import pl.eavo.repository.VehicleRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public String getVehicleMain(Model model) {
        User user = (User) session.getAttribute("user");

        List<Vehicle> vehicles = vehicleRepository.findVehiclesByUser(user);
        if(vehicles.isEmpty()){
            return "redirect:/vehicle/add";
        }else{
            model.addAttribute("vehicle", vehicles.get(0));
        }
        model.addAttribute("user", user);

        return "vehicle";
    }

    @RequestMapping(value = "/vehicle/add", method = RequestMethod.GET)
    public String addVehicleForm(Model model) {
        User user = (User) session.getAttribute("user");
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByUser(user);

        model.addAttribute("user", user);

        if (vehicles.isEmpty()) {
            return "vehicleadd";
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/vehicle/add", method = RequestMethod.POST)
    public String addVehiclePost(Model model, @RequestParam Vehicle vehicle) {

        vehicleRepository.save(vehicle);

        return "vehicle";
    }

    @RequestMapping(value = "/vehicle/edit", method = RequestMethod.GET)
    public String editVehicleForm(Model model) {
        User user = (User) session.getAttribute("user");
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByUser(user);

        model.addAttribute("user", user);

        if (vehicles.isEmpty()) {
            return "vehicleadd";
        } else {
            model.addAttribute("vehicle", vehicles.get(0));
            return "vehicleedit";
        }
    }

    @RequestMapping(value = "/vehicle/edit", method = RequestMethod.POST)
    public String editVehiclePost(Model model, @RequestParam Vehicle vehicle) {

        vehicleRepository.save(vehicle);

        return "vehicle";
    }
}
