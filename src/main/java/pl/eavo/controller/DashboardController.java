package pl.eavo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.eavo.config.CustomSecurityUser;
import pl.eavo.model.Statistics;
import pl.eavo.model.entities.Refuel;
import pl.eavo.model.entities.User;
import pl.eavo.model.entities.Vehicle;
import pl.eavo.repository.RefuelRepository;
import pl.eavo.repository.VehicleRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    private RefuelRepository refuelRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"", "/dashboard"}, method = RequestMethod.GET)
    public String dashboardView(Model model) {
        User user = (User) session.getAttribute("user");
        Vehicle vehicle = vehicleRepository.findVehiclesByUser(user).get(0);

        Statistics statistics = buildDashboardStatisticts(vehicle);

        log.info(statistics.toString());
        log.info(user.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("stats", statistics);

        return "dashboard";
    }

    private Statistics buildDashboardStatisticts(Vehicle vehicle) {
        return new Statistics(
                refuelRepository.findRefuelCountByVehicle(vehicle),
                refuelRepository.findDistanceTraveledByVehicle(vehicle),
                refuelRepository.findFuelSpendingsByVehicle(vehicle),
                refuelRepository.findRepairCountByVehicle(vehicle),
                refuelRepository.findRepairSpendingsByVehicle(vehicle),
                refuelRepository.findAverageConsumptionByVehicle(vehicle),
                refuelRepository.findAverageFuelPriceByVehicle(vehicle),
                refuelRepository.findAverageTimeBetweenRefuelsByVehicle(vehicle)
        );
    }

}
