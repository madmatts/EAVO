package pl.eavo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.eavo.model.entities.Refuel;
import pl.eavo.model.entities.Vehicle;

import java.util.List;

public interface RefuelRepository extends CrudRepository<Refuel, Long> {

    List<Refuel> findAllRefuelsByVehicle(Vehicle vehicle);
}
