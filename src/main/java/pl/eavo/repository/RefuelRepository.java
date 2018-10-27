package pl.eavo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.eavo.model.entities.Refuel;

public interface RefuelRepository extends CrudRepository<Refuel, Long> {
}
