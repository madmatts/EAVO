package pl.eavo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.eavo.model.entities.User;
import pl.eavo.model.entities.Vehicle;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    List<Vehicle> findVehiclesByUser(User user);

}
